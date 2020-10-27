package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class LocationInfoView extends LinearLayout implements View.OnClickListener {
    private TBSpecificationBtn fiw;
    private a fiy;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void bxp();
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
        return this.fiw;
    }

    private void initUI() {
        setOrientation(0);
        setGravity(16);
        b bVar = new b();
        bVar.qa(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pU(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        this.fiw = new TBSpecificationBtn(getContext());
        this.fiw.setConfig(bVar);
        this.fiw.setTextSize(R.dimen.tbds32);
        this.fiw.setOnClickListener(this);
        this.fiw.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fiw, new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63)));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fiw.bqd();
            this.mSkinType = i;
        }
    }

    public void setState(int i, String str) {
        if (!StringUtils.isNull(str)) {
            if (str.contains("·")) {
                int indexOf = str.indexOf("·");
                str = str.substring(0, indexOf) + str.substring(indexOf + 1, str.length());
            }
            this.fiw.setText(at.cutChineseAndEnglishWithSuffix(str, 8, StringHelper.STRING_MORE));
        } else if (i == 1) {
            this.fiw.setText(getContext().getString(R.string.location_loading));
        } else {
            this.fiw.setText(getContext().getString(R.string.location_where_are_you));
        }
        this.fiw.eTf = Integer.valueOf(i);
    }

    public void setLocationClickListener(a aVar) {
        this.fiy = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fiy != null) {
            this.fiy.bxp();
        }
    }
}
