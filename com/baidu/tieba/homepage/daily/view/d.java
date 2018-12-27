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
    private int evA;
    private int evB;
    private List<e.a> evg;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.evA = ((((l.aO(context) - (l.h(context, e.C0210e.tbds44) * 2)) - l.h(context, e.C0210e.tbds60)) / 2) - l.h(context, e.C0210e.tbds104)) - l.h(context, e.C0210e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.evg = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.evg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oB */
    public e.a getItem(int i) {
        return (e.a) v.d(this.evg, i);
    }

    public String aLl() {
        e.a aVar = (e.a) v.d(this.evg, 0);
        if (aVar != null) {
            return aVar.aLl();
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
            aVar2.evC = (TbImageView) view.findViewById(e.g.topic_pic);
            aVar2.evu = (TextView) view.findViewById(e.g.topic_title);
            aVar2.evD = (TextView) view.findViewById(e.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.evC.startLoad(item.aLj(), 10, false);
            aVar.evu.setText(this.mContext.getString(e.j.daily_topic_name, b(aVar.evu.getPaint(), item.yY(), this.evA)));
            aVar.evD.setText(item.aLk());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.evB <= 0) {
            this.evB = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.evB);
    }

    /* loaded from: classes6.dex */
    private static class a {
        public TbImageView evC;
        public TextView evD;
        public TextView evu;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.evC.setBorderColor(al.getColor(e.d.black_alpha15));
                al.h(this.evu, e.d.cp_cont_b);
                al.h(this.evD, e.d.cp_cont_d);
            }
        }
    }
}
