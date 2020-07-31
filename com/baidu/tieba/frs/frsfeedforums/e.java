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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> dVN;
    private LikeModel emT;
    private List<FeedForumData> hSM;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.dVN.getOrignalPage()).checkUpIsLogin()) {
                        e.this.emT.fz(feedForumData.getForumName(), feedForumData.getForumId());
                        ap apVar = new ap("c10048");
                        apVar.dn("fid", feedForumData.getForumId());
                        if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(apVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.dVN.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new ap("c10050").dn("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hiv = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bB(e.this.emT.getErrorCode(), e.this.emT.getErrorString())) {
                AntiHelper.aW(e.this.dVN.getPageActivity(), e.this.emT.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.emT.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.emT.getErrorString());
                }
            } else {
                u uVar = (u) obj;
                uVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.dVN = tbPageContext;
        this.emT = new LikeModel(tbPageContext);
        this.emT.setLoadDataCallBack(this.hiv);
    }

    public void setData(List<FeedForumData> list) {
        this.hSM = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hSM != null) {
            return this.hSM.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hSM != null) {
            return this.hSM.get(i);
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
            view = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.hSU.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.feu.setOnClickListener(this.mOnClickListener);
        bVar.hSR.setPlaceHolder(1);
        bVar.hSR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.hSR.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.hSS.setText(String.format(this.dVN.getPageActivity().getString(R.string.attention_post_count), vx(feedForumData.getMemberCount()), vx(feedForumData.getPostNum())));
        bVar.hST.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.hSU.setClickable(true);
            bVar.hSU.setOnClickListener(this.mOnClickListener);
            bVar.hSU.setEnabled(true);
            bVar.hSU.aM(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.aho != this.mSkinType) {
            ao.setBackgroundResource(bVar.feu, R.drawable.frs_like_feed_forum_item_bg);
            ao.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ao.setViewTextColor(bVar.hSS, R.color.cp_cont_c, 1);
            ao.setViewTextColor(bVar.hST, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                ao.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.aho = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.hSU != null) {
            bVar.hSU.aM(true);
            bVar.hSU.setEnabled(false);
        }
    }

    private String vx(int i) {
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
