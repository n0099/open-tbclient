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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> adf;
    private LikeModel bmW;
    private List<FeedForumData> dgc;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            FeedForumData feedForumData;
            b bVar = (b) view2.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view2.getId() == d.g.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.adf.getOrignalPage()).checkUpIsLogin()) {
                        e.this.bmW.cb(feedForumData.getForumName(), feedForumData.getForumId());
                        TiebaStatic.log(new al("c10048").ac(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                    }
                } else if (view2.getId() == d.g.frs_like_feed_forum_item) {
                    e.this.adf.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(e.this.adf.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new al("c10050").ac(ImageViewerConfig.FORUM_ID, feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d cHY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void f(Object obj) {
            if (AntiHelper.tt(e.this.bmW.getErrorCode())) {
                AntiHelper.am(e.this.adf.getPageActivity(), e.this.bmW.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.bmW.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.bmW.getErrorString());
                }
            } else {
                r rVar = (r) obj;
                rVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.adf = tbPageContext;
        this.bmW = new LikeModel(tbPageContext);
        this.bmW.setLoadDataCallBack(this.cHY);
    }

    public void setData(List<FeedForumData> list) {
        this.dgc = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dgc != null) {
            return this.dgc.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.dgc != null) {
            return this.dgc.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view2 == null) {
            view2 = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view2);
            view2.setTag(bVar2);
            bVar2.dgk.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view2.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.bee.setOnClickListener(this.mOnClickListener);
        bVar.dgh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.dgh.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.dgi.setText(String.format(this.adf.getPageActivity().getString(d.k.attention_post_count), kA(feedForumData.getMemberCount()), kA(feedForumData.getPostNum())));
        bVar.dgj.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.dgk.setClickable(true);
            bVar.dgk.setOnClickListener(this.mOnClickListener);
            bVar.dgk.setEnabled(true);
            bVar.dgk.aQ(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view2;
    }

    private void b(b bVar) {
        if (bVar.aqQ != this.mSkinType) {
            ak.i(bVar.bee, d.f.frs_like_feed_forum_item_bg);
            ak.c(bVar.mTitle, d.C0126d.cp_cont_b, 1);
            ak.c(bVar.dgi, d.C0126d.cp_cont_c, 1);
            ak.c(bVar.dgj, d.C0126d.cp_link_tip_d, 1);
            if (bVar.bwn != null) {
                ak.j(bVar.bwn, d.C0126d.cp_bg_line_b);
            }
            bVar.aqQ = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.dgk != null) {
            bVar.dgk.aQ(true);
            bVar.dgk.setEnabled(false);
        }
    }

    private String kA(int i) {
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
