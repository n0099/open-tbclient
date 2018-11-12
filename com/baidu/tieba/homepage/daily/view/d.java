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
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.daily.b.e;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends BaseAdapter {
    private int elO;
    private int elP;
    private List<e.a> elu;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.elO = ((((l.aO(context) - (l.h(context, e.C0200e.tbds44) * 2)) - l.h(context, e.C0200e.tbds60)) / 2) - l.h(context, e.C0200e.tbds104)) - l.h(context, e.C0200e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.elu = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.elu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nU */
    public e.a getItem(int i) {
        return (e.a) v.d(this.elu, i);
    }

    public String aIF() {
        e.a aVar = (e.a) v.d(this.elu, 0);
        if (aVar != null) {
            return aVar.aIF();
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
            view = LayoutInflater.from(this.mContext).inflate(e.h.daily_topic_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.elQ = (TbImageView) view.findViewById(e.g.topic_pic);
            aVar2.elI = (TextView) view.findViewById(e.g.topic_title);
            aVar2.elR = (TextView) view.findViewById(e.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.elQ.startLoad(item.aID(), 10, false);
            aVar.elI.setText(this.mContext.getString(e.j.daily_topic_name, b(aVar.elI.getPaint(), item.xU(), this.elO)));
            aVar.elR.setText(item.aIE());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.elP <= 0) {
            this.elP = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.elP);
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TextView elI;
        public TbImageView elQ;
        public TextView elR;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.elQ.setBorderColor(al.getColor(e.d.black_alpha15));
                al.h(this.elI, e.d.cp_cont_b);
                al.h(this.elR, e.d.cp_cont_d);
            }
        }
    }
}
