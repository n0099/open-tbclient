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
    private int gfE;
    private int gfF;
    private List<e.a> gfi;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.gfE = ((((l.getEquipmentWidth(context) - (l.getDimens(context, R.dimen.tbds44) * 2)) - l.getDimens(context, R.dimen.tbds60)) / 2) - l.getDimens(context, R.dimen.tbds104)) - l.getDimens(context, R.dimen.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.gfi = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.gfi);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sG */
    public e.a getItem(int i) {
        return (e.a) v.getItem(this.gfi, i);
    }

    public String bto() {
        e.a aVar = (e.a) v.getItem(this.gfi, 0);
        if (aVar != null) {
            return aVar.bto();
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
            aVar2.gfG = (TbImageView) view.findViewById(R.id.topic_pic);
            aVar2.gfy = (TextView) view.findViewById(R.id.topic_title);
            aVar2.gfH = (TextView) view.findViewById(R.id.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.gfG.startLoad(item.btm(), 10, false);
            aVar.gfy.setText(this.mContext.getString(R.string.daily_topic_name, a(aVar.gfy.getPaint(), item.ahN(), this.gfE)));
            aVar.gfH.setText(item.btn());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String a(TextPaint textPaint, String str, int i) {
        if (this.gfF <= 0) {
            this.gfF = i - l.getTextWidth(textPaint, "##");
        }
        return l.getTextOmit(textPaint, str, this.gfF);
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TbImageView gfG;
        public TextView gfH;
        public TextView gfy;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.gfG.setBorderColor(am.getColor(R.color.black_alpha15));
                am.setViewTextColor(this.gfy, (int) R.color.cp_cont_b);
                am.setViewTextColor(this.gfH, (int) R.color.cp_cont_d);
            }
        }
    }
}
