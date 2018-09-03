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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.daily.b.e;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private List<e.a> dUN;
    private int dVi;
    private int dVj;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.dVi = ((((l.ah(context) - (l.f(context, f.e.tbds44) * 2)) - l.f(context, f.e.tbds60)) / 2) - l.f(context, f.e.tbds104)) - l.f(context, f.e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.dUN = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.dUN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mA */
    public e.a getItem(int i) {
        return (e.a) w.d(this.dUN, i);
    }

    public String aDC() {
        e.a aVar = (e.a) w.d(this.dUN, 0);
        if (aVar != null) {
            return aVar.aDC();
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
            view = LayoutInflater.from(this.mContext).inflate(f.h.daily_topic_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.dVk = (TbImageView) view.findViewById(f.g.topic_pic);
            aVar2.dVc = (TextView) view.findViewById(f.g.topic_title);
            aVar2.dVl = (TextView) view.findViewById(f.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.dVk.startLoad(item.aDA(), 10, false);
            aVar.dVc.setText(this.mContext.getString(f.j.daily_topic_name, b(aVar.dVc.getPaint(), item.uB(), this.dVi)));
            aVar.dVl.setText(item.aDB());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.dVj <= 0) {
            this.dVj = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.dVj);
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView dVc;
        public TbImageView dVk;
        public TextView dVl;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.dVk.setBorderColor(am.getColor(f.d.black_alpha15));
                am.h(this.dVc, f.d.cp_cont_b);
                am.h(this.dVl, f.d.cp_cont_d);
            }
        }
    }
}
