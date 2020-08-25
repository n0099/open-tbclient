package com.baidu.tieba.frs.servicearea;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.aa;
import com.baidu.tieba.tbadkCore.z;
/* loaded from: classes16.dex */
public class f implements b {
    private Context mContext;
    private LinearLayout mRootView;

    public f(Context context) {
        this.mContext = context;
        this.mRootView = new LinearLayout(context);
        this.mRootView.setOrientation(0);
    }

    private View fa(Context context) {
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
    public void setData(z zVar) {
        if (zVar != null && !y.isEmpty(zVar.dataList)) {
            this.mRootView.removeAllViews();
            if (zVar.mdS == 2) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = l.getDimens(this.mContext, R.dimen.tbds44);
                this.mRootView.addView(fa(this.mContext), layoutParams);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = l.getDimens(this.mContext, R.dimen.tbds104);
                this.mRootView.addView(fa(this.mContext), layoutParams2);
            } else if (zVar.mdS == 3) {
                int equipmentWidth = l.getEquipmentWidth(this.mContext) / 3;
                for (int i = 0; i < 3; i++) {
                    this.mRootView.addView(fa(this.mContext), new LinearLayout.LayoutParams(equipmentWidth, -2));
                }
            }
            for (int i2 = 0; i2 < this.mRootView.getChildCount(); i2++) {
                final aa aaVar = zVar.dataList.get(i2);
                if (aaVar != null) {
                    ((TbImageView) this.mRootView.getChildAt(i2).findViewById(R.id.service_img)).startLoad(aaVar.imageUrl, 10, false);
                    ((TextView) this.mRootView.getChildAt(i2).findViewById(R.id.service_name)).setText(at.cutChineseAndEnglishWithSuffix(aaVar.name, 8, ""));
                    final View findViewById = this.mRootView.getChildAt(i2).findViewById(R.id.service_red_dot);
                    findViewById.setVisibility(aaVar.hvJ ? 0 : 8);
                    this.mRootView.getChildAt(i2).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.servicearea.f.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (aaVar != null && aaVar.mdT != null) {
                                TiebaStatic.log(new aq("c13274").u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("fid", aaVar.forumId).dD("obj_source", "frs_card").dD("obj_id", aaVar.mdT.id).dD("obj_name", aaVar.mdT.name).ai("obj_param1", aaVar.mdT.dPG.intValue()));
                            }
                            e.a(view.getContext(), aaVar, findViewById);
                            e.c(aaVar);
                        }
                    });
                    e.b(aaVar);
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
                ap.setViewTextColor((TextView) this.mRootView.getChildAt(i3).findViewById(R.id.service_name), R.color.cp_cont_b);
                this.mRootView.getChildAt(i3).findViewById(R.id.service_red_dot).setBackground(ap.getDrawable(R.drawable.frs_service_red_dot));
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }
}
