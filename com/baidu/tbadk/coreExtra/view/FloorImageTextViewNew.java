package com.baidu.tbadk.coreExtra.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int dnt = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int dnu = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView dnl;
    private EditorScrollView dnm;
    private int dnn;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        am.setBackgroundColor(this, R.color.black_alpha50);
        this.dnl = (TbRichTextView) findViewById(R.id.textview);
        this.dnl.setVerticalScrollBarEnabled(true);
        this.dnl.setTextSize(dmx);
        this.dnl.setTextColor(am.getColor(R.color.white_alpha83));
        this.dnm = (EditorScrollView) findViewById(R.id.scrollview);
        this.dnm.setPadding(0, TOP, 0, BOTTOM);
        this.dnm.setOnTouchListener(this.dmA);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (aKh()) {
                    this.dnn = dnu + TOP + BOTTOM;
                } else {
                    this.dnn = dnt + TOP + BOTTOM;
                }
            } else {
                this.dnn = -2;
            }
            lC(this.dnn);
        }
    }

    private boolean aKh() {
        float equipmentDensity = l.getEquipmentDensity(getContext());
        int equipmentHeight = l.getEquipmentHeight(getContext());
        int equipmentWidth = l.getEquipmentWidth(getContext());
        if (equipmentDensity != 3.0d || equipmentWidth < 1920 || equipmentHeight < 2049) {
            if (equipmentDensity != 3.0d || equipmentWidth < 1080 || equipmentHeight < 2280) {
                return ((double) equipmentDensity) == 3.5d && equipmentHeight >= 2434;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.dmy = imageUrlData;
        JSONArray jSONArray2 = null;
        if (imageUrlData != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                jSONArray = new JSONArray(imageUrlData.richTextArray);
                jSONArray2 = jSONArray;
                if (imageUrlData == null && jSONArray2 != null && jSONArray2.length() > 0) {
                    setVisibility(0);
                    com.baidu.tieba.view.c.cRV().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(uj(a.toString()));
                    this.dnl.setText(a);
                    return;
                }
                setVisibility(8);
            }
        }
        jSONArray = null;
        jSONArray2 = jSONArray;
        if (imageUrlData == null) {
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void t(boolean z, boolean z2) {
        if (z2) {
            gf(z);
        } else {
            setExpandState(z);
        }
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(0);
            if (z) {
                layoutParams.height = this.dnn;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }

    private void gf(boolean z) {
        ValueAnimator ofInt;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i = layoutParams.height;
            setVisibility(0);
            if (z) {
                ofInt = ValueAnimator.ofInt(0, this.dnn);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (layoutParams != null) {
                            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            FloorImageTextViewNew.this.setLayoutParams(layoutParams);
                        }
                    }
                });
                TiebaStatic.log(new an("c13336").cp("uid", this.mUserId).cp("obj_locate", "2"));
            } else {
                ofInt = ValueAnimator.ofInt(i, 0);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (layoutParams != null) {
                            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            FloorImageTextViewNew.this.setLayoutParams(layoutParams);
                        }
                    }
                });
                TiebaStatic.log(new an("c13336").cp("uid", this.mUserId).cp("obj_locate", "1"));
            }
            ofInt.start();
        }
    }
}
