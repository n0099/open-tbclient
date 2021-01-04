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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {
    private TBSpecificationBtn fEG;
    private a fEH;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bEZ();
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
        return this.fEG;
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        b bVar = new b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.ro(R.color.CAM_X0110);
        bVar.rr(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rq(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        this.fEG = new TBSpecificationBtn(getContext());
        this.fEG.setConfig(bVar);
        this.fEG.setTextSize(R.dimen.T_X09);
        this.fEG.setOnClickListener(this);
        this.fEG.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fEG, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fEG.bxO();
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.fEG.setText(at.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE));
        } else if (i == 1) {
            this.fEG.setText(getContext().getString(R.string.location_loading));
        } else {
            this.fEG.setText(getContext().getString(R.string.location_where_are_you));
        }
        this.fEG.fpg = Integer.valueOf(i);
    }

    public void setLocationClickListener(a aVar) {
        this.fEH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fEH != null) {
            this.fEH.bEZ();
        }
    }
}
