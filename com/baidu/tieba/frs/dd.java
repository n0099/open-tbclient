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
public class dd extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> MX;
    private com.baidu.tieba.tbadkCore.w MY;
    private List<FeedForumData> bnh;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new de(this);
    private com.baidu.adp.base.g bbu = new df(this);

    public dd(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.MX = tbPageContext;
        this.MY = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MY.setLoadDataCallBack(this.bbu);
    }

    public void setData(List<FeedForumData> list) {
        this.bnh = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bnh != null) {
            return this.bnh.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bnh != null) {
            return this.bnh.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        cf cfVar;
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.MX.getPageActivity()).inflate(t.h.frs_more_feed_forum_item, (ViewGroup) null);
            cf cfVar2 = new cf(view);
            view.setTag(cfVar2);
            cfVar2.bnp.setTag(cfVar2);
            cfVar = cfVar2;
        } else {
            cfVar = (cf) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (cfVar == null) {
            return null;
        }
        cfVar.position = i;
        cfVar.aNr.setOnClickListener(this.mOnClickListener);
        cfVar.bnm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        cfVar.bnm.c(feedForumData.getAvatar(), 15, false);
        cfVar.aSh.setText(feedForumData.getForumName());
        cfVar.bnn.setText(String.format(this.MX.getPageActivity().getString(t.j.attention_post_count), gJ(feedForumData.getMemberCount()), gJ(feedForumData.getPostNum())));
        cfVar.bno.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            cfVar.bnp.setClickable(true);
            cfVar.bnp.setOnClickListener(this.mOnClickListener);
            cfVar.bnp.setText(t.j.attention_n);
            cfVar.bnp.setEnabled(true);
            com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_i, 1);
        } else {
            a(cfVar);
        }
        b(cfVar);
        return view;
    }

    private void b(cf cfVar) {
        if (cfVar.aik != this.mSkinType) {
            com.baidu.tbadk.core.util.at.k(cfVar.aNr, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.at.b(cfVar.aSh, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bnn, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bno, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.at.k(cfVar.bnp, t.f.btn_frs_feed_forum_attention);
            if (cfVar.bnp.isEnabled()) {
                com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_e, 1);
            }
            if (cfVar.aTu != null) {
                com.baidu.tbadk.core.util.at.l(cfVar.aTu, t.d.cp_bg_line_b);
            }
            cfVar.aik = this.mSkinType;
        }
    }

    private void a(cf cfVar) {
        if (cfVar != null && cfVar.bnp != null) {
            cfVar.bnp.setText(this.MX.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.at.b(cfVar.bnp, t.d.cp_cont_e, 1);
            cfVar.bnp.setEnabled(false);
        }
    }

    private String gJ(int i) {
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

    public void a(List<FeedForumData> list, com.baidu.tieba.tbadkCore.x xVar) {
        if (list != null && list.size() > 0 && xVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(xVar.getFid())) {
                    feedForumData.setIsLike(xVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
