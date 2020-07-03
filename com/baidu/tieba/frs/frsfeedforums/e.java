package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> dPv;
    private LikeModel egK;
    private List<FeedForumData> hMN;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.dPv.getOrignalPage()).checkUpIsLogin()) {
                        e.this.egK.fx(feedForumData.getForumName(), feedForumData.getForumId());
                        ao aoVar = new ao("c10048");
                        aoVar.dk("fid", feedForumData.getForumId());
                        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aoVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.dPv.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new ao("c10050").dk("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hcL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bA(e.this.egK.getErrorCode(), e.this.egK.getErrorString())) {
                AntiHelper.aX(e.this.dPv.getPageActivity(), e.this.egK.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.egK.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.egK.getErrorString());
                }
            } else {
                u uVar = (u) obj;
                uVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.dPv = tbPageContext;
        this.egK = new LikeModel(tbPageContext);
        this.egK.setLoadDataCallBack(this.hcL);
    }

    public void setData(List<FeedForumData> list) {
        this.hMN = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hMN != null) {
            return this.hMN.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hMN != null) {
            return this.hMN.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.hMV.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.eZS.setOnClickListener(this.mOnClickListener);
        bVar.hMS.setPlaceHolder(1);
        bVar.hMS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.hMS.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.hMT.setText(String.format(this.dPv.getPageActivity().getString(R.string.attention_post_count), vf(feedForumData.getMemberCount()), vf(feedForumData.getPostNum())));
        bVar.hMU.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.hMV.setClickable(true);
            bVar.hMV.setOnClickListener(this.mOnClickListener);
            bVar.hMV.setEnabled(true);
            bVar.hMV.hA(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ahx != this.mSkinType) {
            an.setBackgroundResource(bVar.eZS, R.drawable.frs_like_feed_forum_item_bg);
            an.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            an.setViewTextColor(bVar.hMT, R.color.cp_cont_c, 1);
            an.setViewTextColor(bVar.hMU, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                an.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.ahx = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.hMV != null) {
            bVar.hMV.hA(true);
            bVar.hMV.setEnabled(false);
        }
    }

    private String vf(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    public void a(List<FeedForumData> list, u uVar) {
        if (list != null && list.size() > 0 && uVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(uVar.getFid())) {
                    feedForumData.setIsLike(uVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
