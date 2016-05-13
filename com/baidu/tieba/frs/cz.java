package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class cz extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> Do;
    private com.baidu.tieba.tbadkCore.x Dp;
    private List<FeedForumData> biJ;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new da(this);
    private com.baidu.adp.base.g aXD = new db(this);

    public cz(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.Do = tbPageContext;
        this.Dp = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.Dp.setLoadDataCallBack(this.aXD);
    }

    public void setData(List<FeedForumData> list) {
        this.biJ = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.biJ != null) {
            return this.biJ.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.biJ != null) {
            return this.biJ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ce ceVar;
        this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.Do.getPageActivity()).inflate(t.h.frs_more_feed_forum_item, (ViewGroup) null);
            ce ceVar2 = new ce(view);
            view.setTag(ceVar2);
            ceVar2.biS.setTag(ceVar2);
            ceVar = ceVar2;
        } else {
            ceVar = (ce) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (ceVar == null) {
            return null;
        }
        ceVar.position = i;
        ceVar.aJB.setOnClickListener(this.mOnClickListener);
        ceVar.biP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        ceVar.biP.c(feedForumData.getAvatar(), 15, false);
        ceVar.aOG.setText(feedForumData.getForumName());
        ceVar.biQ.setText(String.format(this.Do.getPageActivity().getString(t.j.attention_post_count), go(feedForumData.getMemberCount()), go(feedForumData.getPostNum())));
        ceVar.biR.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            ceVar.biS.setClickable(true);
            ceVar.biS.setOnClickListener(this.mOnClickListener);
            ceVar.biS.setText(t.j.attention_n);
            ceVar.biS.setEnabled(true);
            com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_i, 1);
        } else {
            a(ceVar);
        }
        b(ceVar);
        return view;
    }

    private void b(ce ceVar) {
        if (ceVar.aej != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(ceVar.aJB, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.at.c(ceVar.aOG, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biQ, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biR, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.at.k(ceVar.biS, t.f.btn_frs_feed_forum_attention);
            if (ceVar.biS.isEnabled()) {
                com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_e, 1);
            }
            if (ceVar.aPI != null) {
                com.baidu.tbadk.core.util.at.l(ceVar.aPI, t.d.cp_bg_line_b);
            }
            ceVar.aej = this.mSkinType;
        }
    }

    private void a(ce ceVar) {
        if (ceVar != null && ceVar.biS != null) {
            ceVar.biS.setText(this.Do.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.at.c(ceVar.biS, t.d.cp_cont_e, 1);
            ceVar.biS.setEnabled(false);
        }
    }

    private String go(int i) {
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
