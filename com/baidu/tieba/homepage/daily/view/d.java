package com.baidu.tieba.homepage.daily.view;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private int fIH;
    private int fII;
    private List<e.a> fIl;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.fIH = ((((l.aO(context) - (l.h(context, d.e.tbds44) * 2)) - l.h(context, d.e.tbds60)) / 2) - l.h(context, d.e.tbds104)) - l.h(context, d.e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.fIl = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.fIl);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sl */
    public e.a getItem(int i) {
        return (e.a) v.c(this.fIl, i);
    }

    public String blL() {
        e.a aVar = (e.a) v.c(this.fIl, 0);
        if (aVar != null) {
            return aVar.blL();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.daily_topic_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.fIJ = (TbImageView) view.findViewById(d.g.topic_pic);
            aVar2.fIB = (TextView) view.findViewById(d.g.topic_title);
            aVar2.fIK = (TextView) view.findViewById(d.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.fIJ.startLoad(item.blJ(), 10, false);
            aVar.fIB.setText(this.mContext.getString(d.j.daily_topic_name, b(aVar.fIB.getPaint(), item.Ya(), this.fIH)));
            aVar.fIK.setText(item.blK());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.fII <= 0) {
            this.fII = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.fII);
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView fIB;
        public TbImageView fIJ;
        public TextView fIK;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.fIJ.setBorderColor(al.getColor(d.C0277d.black_alpha15));
                al.j(this.fIB, d.C0277d.cp_cont_b);
                al.j(this.fIK, d.C0277d.cp_cont_d);
            }
        }
    }
}
