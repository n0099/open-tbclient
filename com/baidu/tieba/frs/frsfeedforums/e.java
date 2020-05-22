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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> dIF;
    private LikeModel dYI;
    private List<FeedForumData> hyS;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.dIF.getOrignalPage()).checkUpIsLogin()) {
                        e.this.dYI.fq(feedForumData.getForumName(), feedForumData.getForumId());
                        an anVar = new an("c10048");
                        anVar.dh("fid", feedForumData.getForumId());
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            anVar.dh("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(anVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.dIF.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new an("c10050").dh("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d gPR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bv(e.this.dYI.getErrorCode(), e.this.dYI.getErrorString())) {
                AntiHelper.aX(e.this.dIF.getPageActivity(), e.this.dYI.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.dYI.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.dYI.getErrorString());
                }
            } else {
                u uVar = (u) obj;
                uVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.dIF = tbPageContext;
        this.dYI = new LikeModel(tbPageContext);
        this.dYI.setLoadDataCallBack(this.gPR);
    }

    public void setData(List<FeedForumData> list) {
        this.hyS = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hyS != null) {
            return this.hyS.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hyS != null) {
            return this.hyS.get(i);
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
            view = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.hza.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.ePw.setOnClickListener(this.mOnClickListener);
        bVar.hyX.setPlaceHolder(1);
        bVar.hyX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.hyX.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.hyY.setText(String.format(this.dIF.getPageActivity().getString(R.string.attention_post_count), uy(feedForumData.getMemberCount()), uy(feedForumData.getPostNum())));
        bVar.hyZ.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.hza.setClickable(true);
            bVar.hza.setOnClickListener(this.mOnClickListener);
            bVar.hza.setEnabled(true);
            bVar.hza.hr(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.agt != this.mSkinType) {
            am.setBackgroundResource(bVar.ePw, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.hyY, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.hyZ, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                am.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.agt = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.hza != null) {
            bVar.hza.hr(true);
            bVar.hza.setEnabled(false);
        }
    }

    private String uy(int i) {
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
