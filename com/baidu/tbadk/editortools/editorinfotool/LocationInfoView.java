package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {
    private TBSpecificationBtn fva;
    private a fvb;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bCE();
    }

    public LocationInfoView(Context context) {
        this(context, null);
    }

    public LocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        initUI();
    }

    public TBSpecificationBtn getLocationBtn() {
        return this.fva;
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        b bVar = new b();
        bVar.bd(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.rd(R.color.CAM_X0110);
        bVar.rg(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.bc(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rf(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.fva = new TBSpecificationBtn(getContext());
        this.fva.setConfig(bVar);
        this.fva.setTextSize(R.dimen.T_X09);
        this.fva.setOnClickListener(this);
        this.fva.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fva, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fva.bvt();
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.fva.setText(au.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE));
        } else if (i == 1) {
            this.fva.setText(getContext().getString(R.string.location_loading));
        } else {
            this.fva.setText(getContext().getString(R.string.location_where_are_you));
        }
        this.fva.ffy = Integer.valueOf(i);
    }

    public void setLocationClickListener(a aVar) {
        this.fvb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fvb != null) {
            this.fvb.bCE();
        }
    }
}
