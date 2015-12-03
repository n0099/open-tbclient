package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class co extends BaseAdapter {
    private com.baidu.tieba.tbadkCore.x Ml;
    private List<FeedForumData> bbP;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new cp(this);
    private com.baidu.adp.base.g aQL = new cq(this);

    public co(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.Ml = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Ml.setLoadDataCallBack(this.aQL);
    }

    public void setData(List<FeedForumData> list) {
        this.bbP = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbP != null) {
            return this.bbP.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bbP != null) {
            return this.bbP.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bu buVar;
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.g.frs_more_feed_forum_item, (ViewGroup) null);
            bu buVar2 = new bu(view);
            view.setTag(buVar2);
            buVar2.bbX.setTag(buVar2);
            buVar = buVar2;
        } else {
            buVar = (bu) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (buVar == null) {
            return null;
        }
        buVar.position = i;
        buVar.aHS.setOnClickListener(this.mOnClickListener);
        buVar.bbU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        buVar.bbU.d(feedForumData.getAvatar(), 15, false);
        buVar.aUB.setText(feedForumData.getForumName());
        buVar.bbV.setText(String.format(this.mContext.getPageActivity().getString(n.i.attention_post_count), ga(feedForumData.getMemberCount()), ga(feedForumData.getPostNum())));
        buVar.bbW.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            buVar.bbX.setClickable(true);
            buVar.bbX.setOnClickListener(this.mOnClickListener);
            buVar.bbX.setText(n.i.attention_n);
            buVar.bbX.setEnabled(true);
            com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_i, 1);
        } else {
            a(buVar);
        }
        b(buVar);
        return view;
    }

    private void b(bu buVar) {
        if (buVar.afY != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(buVar.aHS, n.e.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.as.b(buVar.aUB, n.c.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbV, n.c.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbW, n.c.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_i, 1);
            com.baidu.tbadk.core.util.as.i((View) buVar.bbX, n.e.btn_frs_feed_forum_attention);
            if (buVar.bbX.isEnabled()) {
                com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_e, 1);
            }
            if (buVar.aWS != null) {
                com.baidu.tbadk.core.util.as.j(buVar.aWS, n.c.cp_bg_line_b);
            }
            buVar.afY = this.mSkinType;
        }
    }

    private void a(bu buVar) {
        if (buVar != null && buVar.bbX != null) {
            buVar.bbX.setText(this.mContext.getString(n.i.already_attentioned));
            com.baidu.tbadk.core.util.as.b(buVar.bbX, n.c.cp_cont_e, 1);
            buVar.bbX.setEnabled(false);
        }
    }

    private String ga(int i) {
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

    public void a(List<FeedForumData> list, com.baidu.tieba.tbadkCore.y yVar) {
        if (list != null && list.size() > 0 && yVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(yVar.getFid())) {
                    feedForumData.setIsLike(yVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
