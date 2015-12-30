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
public class cr extends BaseAdapter {
    private com.baidu.tieba.tbadkCore.x MB;
    private List<FeedForumData> bfO;
    private TbPageContext<FrsMoreFeedForumsActivity> mContext;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new cs(this);
    private com.baidu.adp.base.g aUC = new ct(this);

    public cr(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.mContext = tbPageContext;
        this.MB = new com.baidu.tieba.tbadkCore.x(tbPageContext);
        this.MB.setLoadDataCallBack(this.aUC);
    }

    public void setData(List<FeedForumData> list) {
        this.bfO = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bfO != null) {
            return this.bfO.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.bfO != null) {
            return this.bfO.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bx bxVar;
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.mContext.getPageActivity()).inflate(n.h.frs_more_feed_forum_item, (ViewGroup) null);
            bx bxVar2 = new bx(view);
            view.setTag(bxVar2);
            bxVar2.bfW.setTag(bxVar2);
            bxVar = bxVar2;
        } else {
            bxVar = (bx) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bxVar == null) {
            return null;
        }
        bxVar.position = i;
        bxVar.aJq.setOnClickListener(this.mOnClickListener);
        bxVar.bfT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bxVar.bfT.d(feedForumData.getAvatar(), 15, false);
        bxVar.aOn.setText(feedForumData.getForumName());
        bxVar.bfU.setText(String.format(this.mContext.getPageActivity().getString(n.j.attention_post_count), fV(feedForumData.getMemberCount()), fV(feedForumData.getPostNum())));
        bxVar.bfV.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bxVar.bfW.setClickable(true);
            bxVar.bfW.setOnClickListener(this.mOnClickListener);
            bxVar.bfW.setText(n.j.attention_n);
            bxVar.bfW.setEnabled(true);
            com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_i, 1);
        } else {
            a(bxVar);
        }
        b(bxVar);
        return view;
    }

    private void b(bx bxVar) {
        if (bxVar.ahf != this.mSkinType) {
            com.baidu.tbadk.core.util.as.i(bxVar.aJq, n.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.as.b(bxVar.aOn, n.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfU, n.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfV, n.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.as.i((View) bxVar.bfW, n.f.btn_frs_feed_forum_attention);
            if (bxVar.bfW.isEnabled()) {
                com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_e, 1);
            }
            if (bxVar.aOM != null) {
                com.baidu.tbadk.core.util.as.j(bxVar.aOM, n.d.cp_bg_line_b);
            }
            bxVar.ahf = this.mSkinType;
        }
    }

    private void a(bx bxVar) {
        if (bxVar != null && bxVar.bfW != null) {
            bxVar.bfW.setText(this.mContext.getString(n.j.already_attentioned));
            com.baidu.tbadk.core.util.as.b(bxVar.bfW, n.d.cp_cont_e, 1);
            bxVar.bfW.setEnabled(false);
        }
    }

    private String fV(int i) {
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
