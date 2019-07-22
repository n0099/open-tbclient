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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.e;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private List<e.a> gdU;
    private int ger;
    private int ges;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.ger = ((((l.af(context) - (l.g(context, R.dimen.tbds44) * 2)) - l.g(context, R.dimen.tbds60)) / 2) - l.g(context, R.dimen.tbds104)) - l.g(context, R.dimen.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.gdU = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.gdU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tG */
    public e.a getItem(int i) {
        return (e.a) v.c(this.gdU, i);
    }

    public String bvk() {
        e.a aVar = (e.a) v.c(this.gdU, 0);
        if (aVar != null) {
            return aVar.bvk();
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
            view = LayoutInflater.from(this.mContext).inflate(R.layout.daily_topic_item_view, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.get = (TbImageView) view.findViewById(R.id.topic_pic);
            aVar2.gek = (TextView) view.findViewById(R.id.topic_title);
            aVar2.geu = (TextView) view.findViewById(R.id.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.get.startLoad(item.bvi(), 10, false);
            aVar.gek.setText(this.mContext.getString(R.string.daily_topic_name, b(aVar.gek.getPaint(), item.adG(), this.ger)));
            aVar.geu.setText(item.bvj());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.ges <= 0) {
            this.ges = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.ges);
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView gek;
        public TbImageView get;
        public TextView geu;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.get.setBorderColor(am.getColor(R.color.black_alpha15));
                am.j(this.gek, R.color.cp_cont_b);
                am.j(this.geu, R.color.cp_cont_d);
            }
        }
    }
}
