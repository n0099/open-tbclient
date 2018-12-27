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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private LikeModel aLn;
    private List<FeedForumData> dVw;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == e.g.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.mContext.getOrignalPage()).checkUpIsLogin()) {
                        e.this.aLn.cK(feedForumData.getForumName(), feedForumData.getForumId());
                        am amVar = new am("c10048");
                        amVar.aA(ImageViewerConfig.FORUM_ID, feedForumData.getForumId());
                        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(amVar);
                    }
                } else if (view.getId() == e.g.frs_like_feed_forum_item) {
                    e.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new am("c10050").aA(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d drB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void m(Object obj) {
            if (AntiHelper.aj(e.this.aLn.getErrorCode(), e.this.aLn.getErrorString())) {
                AntiHelper.aJ(e.this.mContext.getPageActivity(), e.this.aLn.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.aLn.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.aLn.getErrorString());
                }
            } else {
                r rVar = (r) obj;
                rVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.aLn = new LikeModel(tbPageContext);
        this.aLn.setLoadDataCallBack(this.drB);
    }

    public void setData(List<FeedForumData> list) {
        this.dVw = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dVw != null) {
            return this.dVw.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dVw != null) {
            return this.dVw.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.dVE.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.bCB.setOnClickListener(this.mOnClickListener);
        bVar.dVB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.dVB.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.dVC.setText(String.format(this.mContext.getPageActivity().getString(e.j.attention_post_count), mQ(feedForumData.getMemberCount()), mQ(feedForumData.getPostNum())));
        bVar.dVD.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.dVE.setClickable(true);
            bVar.dVE.setOnClickListener(this.mOnClickListener);
            bVar.dVE.setEnabled(true);
            bVar.dVE.bK(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.aLH != this.mSkinType) {
            al.i(bVar.bCB, e.f.frs_like_feed_forum_item_bg);
            al.c(bVar.mTitle, e.d.cp_cont_b, 1);
            al.c(bVar.dVC, e.d.cp_cont_c, 1);
            al.c(bVar.dVD, e.d.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                al.j(bVar.mDivider, e.d.cp_bg_line_b);
            }
            bVar.aLH = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.dVE != null) {
            bVar.dVE.bK(true);
            bVar.dVE.setEnabled(false);
        }
    }

    private String mQ(int i) {
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

    public void a(List<FeedForumData> list, r rVar) {
        if (list != null && list.size() > 0 && rVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(rVar.getFid())) {
                    feedForumData.setIsLike(rVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
