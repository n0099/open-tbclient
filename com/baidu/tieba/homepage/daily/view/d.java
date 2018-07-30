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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.e;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private List<e.a> dUS;
    private int dVn;
    private int dVo;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.dVn = ((((l.ah(context) - (l.f(context, d.e.tbds44) * 2)) - l.f(context, d.e.tbds60)) / 2) - l.f(context, d.e.tbds104)) - l.f(context, d.e.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.dUS = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.dUS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mA */
    public e.a getItem(int i) {
        return (e.a) w.d(this.dUS, i);
    }

    public String aDF() {
        e.a aVar = (e.a) w.d(this.dUS, 0);
        if (aVar != null) {
            return aVar.aDF();
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
            aVar2.dVp = (TbImageView) view.findViewById(d.g.topic_pic);
            aVar2.dVh = (TextView) view.findViewById(d.g.topic_title);
            aVar2.dVq = (TextView) view.findViewById(d.g.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.dVp.startLoad(item.aDD(), 10, false);
            aVar.dVh.setText(this.mContext.getString(d.j.daily_topic_name, b(aVar.dVh.getPaint(), item.uC(), this.dVn)));
            aVar.dVq.setText(item.aDE());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.dVo <= 0) {
            this.dVo = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.dVo);
    }

    /* loaded from: classes2.dex */
    private static class a {
        public TextView dVh;
        public TbImageView dVp;
        public TextView dVq;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.dVp.setBorderColor(am.getColor(d.C0140d.black_alpha15));
                am.h(this.dVh, d.C0140d.cp_cont_b);
                am.h(this.dVq, d.C0140d.cp_cont_d);
            }
        }
    }
}
