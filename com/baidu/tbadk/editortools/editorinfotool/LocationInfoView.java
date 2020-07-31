package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {
    private TBSpecificationBtn eAW;
    private a eAX;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void biX();
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
        return this.eAW;
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        c cVar = new c();
        cVar.mX(R.color.cp_cont_b);
        cVar.k(R.drawable.ic_icon_pure_post_location16_svg, 0, true);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.eAW = new TBSpecificationBtn(getContext());
        this.eAW.setConfig(cVar);
        this.eAW.setTextSize(R.dimen.tbds32);
        this.eAW.setOnClickListener(this);
        this.eAW.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.eAW, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eAW.bci();
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.eAW.setText(as.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE));
        } else if (i == 1) {
            this.eAW.setText(getContext().getString(R.string.location_loading));
        } else {
            this.eAW.setText(getContext().getString(R.string.location_where_are_you));
        }
        this.eAW.emo = Integer.valueOf(i);
    }

    public void setLocationClickListener(a aVar) {
        this.eAX = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eAX != null) {
            this.eAX.biX();
        }
    }
}
