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
    private List<e.a> ggC;
    private int ggY;
    private int ggZ;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.ggY = ((((l.af(context) - (l.g(context, R.dimen.tbds44) * 2)) - l.g(context, R.dimen.tbds60)) / 2) - l.g(context, R.dimen.tbds104)) - l.g(context, R.dimen.tbds26);
    }

    public void setData(List<e.a> list) {
        if (list != null) {
            this.ggC = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.ggC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tM */
    public e.a getItem(int i) {
        return (e.a) v.c(this.ggC, i);
    }

    public String bwl() {
        e.a aVar = (e.a) v.c(this.ggC, 0);
        if (aVar != null) {
            return aVar.bwl();
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
            aVar2.gha = (TbImageView) view.findViewById(R.id.topic_pic);
            aVar2.ggS = (TextView) view.findViewById(R.id.topic_title);
            aVar2.ghb = (TextView) view.findViewById(R.id.topic_abstract);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e.a item = getItem(i);
        if (item != null) {
            aVar.gha.startLoad(item.bwj(), 10, false);
            aVar.ggS.setText(this.mContext.getString(R.string.daily_topic_name, b(aVar.ggS.getPaint(), item.adL(), this.ggY)));
            aVar.ghb.setText(item.bwk());
        }
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return view;
    }

    public String b(TextPaint textPaint, String str, int i) {
        if (this.ggZ <= 0) {
            this.ggZ = i - l.c(textPaint, "##");
        }
        return l.a(textPaint, str, this.ggZ);
    }

    /* loaded from: classes4.dex */
    private static class a {
        public TextView ggS;
        public TbImageView gha;
        public TextView ghb;
        private int mSkinType;

        private a() {
            this.mSkinType = 3;
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                this.mSkinType = i;
                this.gha.setBorderColor(am.getColor(R.color.black_alpha15));
                am.j(this.ggS, R.color.cp_cont_b);
                am.j(this.ghb, R.color.cp_cont_d);
            }
        }
    }
}
