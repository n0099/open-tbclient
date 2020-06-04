package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes9.dex */
public class f implements b {
    private Context mContext;
    private LinearLayout mRootView;

    public f(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(0);
    }

    private View eJ(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(0);
        TbClipImageView tbClipImageView = new TbClipImageView(context);
        tbClipImageView.setId(R.id.service_img);
        int dimens = l.getDimens(context, R.dimen.tbds79);
        tbClipImageView.setDrawerType(1);
        tbClipImageView.setIsRound(true);
        tbClipImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tbClipImageView.setPlaceHolder(1);
        linearLayout.addView(tbClipImageView, dimens, dimens);
        TextView textView = new TextView(context);
        textView.setId(R.id.service_name);
        textView.setTextSize(0, l.getDimens(context, R.dimen.tbfontsize36));
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = l.getDimens(context, R.dimen.tbds15);
        linearLayout.addView(textView, layoutParams);
        View view = new View(context);
        view.setId(R.id.service_red_dot);
        int dimens2 = l.getDimens(context, R.dimen.tbds20);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimens2, dimens2);
        layoutParams2.leftMargin = l.getDimens(context, R.dimen.tbds10);
        linearLayout.addView(view, layoutParams2);
        return linearLayout;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public View getView() {
        return this.mRootView;
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void setData(y yVar) {
        if (yVar != null && !v.isEmpty(yVar.dataList)) {
            this.mRootView.removeAllViews();
            if (yVar.lkX == 2) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
                this.mRootView.addView(eJ(this.mContext), layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds104);
                this.mRootView.addView(eJ(this.mContext), layoutParams2);
            } else if (yVar.lkX == 3) {
                int equipmentWidth = l.getEquipmentWidth(this.mContext) / 3;
                for (int i = 0; i < 3; i++) {
                    this.mRootView.addView(eJ(this.mContext), new LinearLayout.LayoutParams(equipmentWidth, -2));
                }
            }
            for (int i2 = 0; i2 < this.mRootView.getChildCount(); i2++) {
                final z zVar = yVar.dataList.get(i2);
                if (zVar != null) {
                    ((TbImageView) this.mRootView.getChildAt(i2).findViewById(R.id.service_img)).startLoad(zVar.imageUrl, 10, false);
                    ((TextView) this.mRootView.getChildAt(i2).findViewById(R.id.service_name)).setText(aq.cutChineseAndEnglishWithSuffix(zVar.name, 8, ""));
                    final View findViewById = this.mRootView.getChildAt(i2).findViewById(R.id.service_red_dot);
                    findViewById.setVisibility(zVar.gQs ? 0 : 8);
                    this.mRootView.getChildAt(i2).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.f.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            e.a(view.getContext(), zVar, findViewById);
                            e.c(zVar);
                        }
                    });
                    e.b(zVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.servicearea.b
    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mRootView.getChildCount()) {
                am.setViewTextColor((TextView) this.mRootView.getChildAt(i3).findViewById(R.id.service_name), (int) R.color.cp_cont_b);
                this.mRootView.getChildAt(i3).findViewById(R.id.service_red_dot).setBackground(am.getDrawable(R.drawable.frs_service_red_dot));
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
