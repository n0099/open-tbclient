package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int fxO = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int fxP = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView eKb;
    private EditorScrollView fxQ;
    private int fxR;
    private boolean fxS;

    public FloorImageTextViewNew(Context context) {
        super(context);
        this.fxS = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        this.eKb = (TbRichTextView) findViewById(R.id.textview);
        this.eKb.setVerticalScrollBarEnabled(true);
        this.eKb.setTextSize(fxg);
        this.eKb.setTextColor(ap.getColor(R.color.white_alpha83));
        this.eKb.fZA = true;
        this.fxQ = (EditorScrollView) findViewById(R.id.scrollview);
        this.fxQ.setPadding(0, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34), 0, BOTTOM);
        this.fxQ.setOnTouchListener(this.fxj);
        ((ViewGroup.MarginLayoutParams) this.fxQ.getLayoutParams()).topMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds174);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 2) {
                if (bzt()) {
                    this.fxR = fxP + TOP + BOTTOM;
                } else {
                    this.fxR = fxO + TOP + BOTTOM;
                }
            } else {
                this.fxR = -2;
            }
            qB(this.fxR);
        }
    }

    private boolean bzt() {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.fxh = imageUrlData;
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
                    this.fxS = true;
                    com.baidu.tieba.view.c.dWg().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a2 = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(Cu(a2.toString()));
                    this.eKb.setText(a2);
                } else {
                    this.fxS = false;
                }
                setVisibility(!this.fxS ? 0 : 8);
            }
        }
        jSONArray = null;
        jSONArray2 = jSONArray;
        if (imageUrlData == null) {
        }
        this.fxS = false;
        setVisibility(!this.fxS ? 0 : 8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void kz(boolean z) {
        setExpandState(z);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(this.fxS ? 0 : 8);
            if (z) {
                layoutParams.height = this.fxR;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }
}
