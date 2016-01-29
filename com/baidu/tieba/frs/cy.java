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
public class cy extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> MR;
    private com.baidu.tieba.tbadkCore.w MS;
    private List<FeedForumData> biw;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new cz(this);
    private com.baidu.adp.base.g aWL = new da(this);

    public cy(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.MR = tbPageContext;
        this.MS = new com.baidu.tieba.tbadkCore.w(tbPageContext);
        this.MS.setLoadDataCallBack(this.aWL);
    }

    public void setData(List<FeedForumData> list) {
        this.biw = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.biw != null) {
            return this.biw.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.biw != null) {
            return this.biw.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        cd cdVar;
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.MR.getPageActivity()).inflate(t.h.frs_more_feed_forum_item, (ViewGroup) null);
            cd cdVar2 = new cd(view);
            view.setTag(cdVar2);
            cdVar2.biE.setTag(cdVar2);
            cdVar = cdVar2;
        } else {
            cdVar = (cd) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (cdVar == null) {
            return null;
        }
        cdVar.position = i;
        cdVar.aKv.setOnClickListener(this.mOnClickListener);
        cdVar.biB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        cdVar.biB.d(feedForumData.getAvatar(), 15, false);
        cdVar.aPr.setText(feedForumData.getForumName());
        cdVar.biC.setText(String.format(this.MR.getPageActivity().getString(t.j.attention_post_count), gs(feedForumData.getMemberCount()), gs(feedForumData.getPostNum())));
        cdVar.biD.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            cdVar.biE.setClickable(true);
            cdVar.biE.setOnClickListener(this.mOnClickListener);
            cdVar.biE.setText(t.j.attention_n);
            cdVar.biE.setEnabled(true);
            com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_i, 1);
        } else {
            a(cdVar);
        }
        b(cdVar);
        return view;
    }

    private void b(cd cdVar) {
        if (cdVar.ahU != this.mSkinType) {
            com.baidu.tbadk.core.util.ar.k(cdVar.aKv, t.f.frs_like_feed_forum_item_bg);
            com.baidu.tbadk.core.util.ar.b(cdVar.aPr, t.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biC, t.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biD, t.d.cp_link_tip_d, 1);
            com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_i, 1);
            com.baidu.tbadk.core.util.ar.k(cdVar.biE, t.f.btn_frs_feed_forum_attention);
            if (cdVar.biE.isEnabled()) {
                com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_i, 1);
            } else {
                com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_e, 1);
            }
            if (cdVar.aQL != null) {
                com.baidu.tbadk.core.util.ar.l(cdVar.aQL, t.d.cp_bg_line_b);
            }
            cdVar.ahU = this.mSkinType;
        }
    }

    private void a(cd cdVar) {
        if (cdVar != null && cdVar.biE != null) {
            cdVar.biE.setText(this.MR.getString(t.j.already_attentioned));
            com.baidu.tbadk.core.util.ar.b(cdVar.biE, t.d.cp_cont_e, 1);
            cdVar.biE.setEnabled(false);
        }
    }

    private String gs(int i) {
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
