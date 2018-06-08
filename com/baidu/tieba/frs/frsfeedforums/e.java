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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private LikeModel bvr;
    private List<FeedForumData> dqv;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == d.g.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.mContext.getOrignalPage()).checkUpIsLogin()) {
                        e.this.bvr.cj(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new am("c10048").ah(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                    }
                } else if (view.getId() == d.g.frs_like_feed_forum_item) {
                    e.this.mContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.mContext.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new am("c10050").ah(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cSk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void i(Object obj) {
            if (AntiHelper.tE(e.this.bvr.getErrorCode())) {
                AntiHelper.ao(e.this.mContext.getPageActivity(), e.this.bvr.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.bvr.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.bvr.getErrorString());
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
        this.bvr = new LikeModel(tbPageContext);
        this.bvr.setLoadDataCallBack(this.cSk);
    }

    public void setData(List<FeedForumData> list) {
        this.dqv = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dqv != null) {
            return this.dqv.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dqv != null) {
            return this.dqv.get(i);
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
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.dqD.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.bmp.setOnClickListener(this.mOnClickListener);
        bVar.dqA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.dqA.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.dqB.setText(String.format(this.mContext.getPageActivity().getString(d.k.attention_post_count), kE(feedForumData.getMemberCount()), kE(feedForumData.getPostNum())));
        bVar.dqC.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.dqD.setClickable(true);
            bVar.dqD.setOnClickListener(this.mOnClickListener);
            bVar.dqD.setEnabled(true);
            bVar.dqD.aU(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.ayX != this.mSkinType) {
            al.i(bVar.bmp, d.f.frs_like_feed_forum_item_bg);
            al.c(bVar.mTitle, d.C0141d.cp_cont_b, 1);
            al.c(bVar.dqB, d.C0141d.cp_cont_c, 1);
            al.c(bVar.dqC, d.C0141d.cp_link_tip_d, 1);
            if (bVar.bFh != null) {
                al.j(bVar.bFh, d.C0141d.cp_bg_line_b);
            }
            bVar.ayX = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.dqD != null) {
            bVar.dqD.aU(true);
            bVar.dqD.setEnabled(false);
        }
    }

    private String kE(int i) {
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
