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
    private int fII;
    private int fIJ;
    private List<e.a> fIm;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.fII = ((((l.aO(context) - (l.h(context, d.e.tbds44) * 2)) - l.h(context, d.e.tbds60)) / 2) - l.h(context, d.e.tbds104)) - l.h(context, d.e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.fIm = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.fIm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sl */
    public e.a getItem(int i) {
        return (e.a) v.c(this.fIm, i);
    }

    public String blM() {
        e.a aVar = (e.a) v.c(this.fIm, 0);
        if (aVar != null) {
            return aVar.blM();
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
            aVar2.fIK = (TbImageView) view.findViewById(d.g.topic_pic);
            aVar2.fIC = (TextView) view.findViewById(d.g.topic_title);
            aVar2.fIL = (TextView) view.findViewById(d.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.fIK.startLoad(item.blK(), 10, false);
            aVar.fIC.setText(this.mContext.getString(d.j.daily_topic_name, b(aVar.fIC.getPaint(), item.Ya(), this.fII)));
            aVar.fIL.setText(item.blL());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.fIJ <= 0) {
            this.fIJ = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.fIJ);
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView fIC;
        public TbImageView fIK;
        public TextView fIL;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.fIK.setBorderColor(al.getColor(d.C0236d.black_alpha15));
                al.j(this.fIC, d.C0236d.cp_cont_b);
                al.j(this.fIL, d.C0236d.cp_cont_d);
            }
        }
    }
}
