package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int fyH = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int fyI = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView eLf;
    private EditorScrollView fyJ;
    private int fyK;
    private boolean fyL;

    public FloorImageTextViewNew(Context context) {
        super(context);
        this.fyL = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        this.eLf = (TbRichTextView) findViewById(R.id.textview);
        this.eLf.setVerticalScrollBarEnabled(true);
        this.eLf.setTextSize(fxY);
        this.eLf.setTextColor(ao.getColor(R.color.white_alpha83));
        this.eLf.gas = true;
        this.fyJ = (EditorScrollView) findViewById(R.id.scrollview);
        this.fyJ.setPadding(0, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34), 0, BOTTOM);
        this.fyJ.setOnTouchListener(this.fyb);
        ((ViewGroup.MarginLayoutParams) this.fyJ.getLayoutParams()).topMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds174);
        setVisibility(8);
    }

    private void f(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 2) {
                if (bCR()) {
                    this.fyK = fyI + TOP + BOTTOM;
                } else {
                    this.fyK = fyH + TOP + BOTTOM;
                }
            } else {
                this.fyK = -2;
            }
            sb(this.fyK);
        }
    }

    private boolean bCR() {
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
        this.fxZ = imageUrlData;
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
                    this.fyL = true;
                    com.baidu.tieba.view.c.dXv().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a2 = TbRichTextView.a(getContext(), jSONArray2, false);
                    f(Di(a2.toString()));
                    this.eLf.setText(a2);
                } else {
                    this.fyL = false;
                }
                setVisibility(!this.fyL ? 0 : 8);
            }
        }
        jSONArray = null;
        jSONArray2 = jSONArray;
        if (imageUrlData == null) {
        }
        this.fyL = false;
        setVisibility(!this.fyL ? 0 : 8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void kA(boolean z) {
        setExpandState(z);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(this.fyL ? 0 : 8);
            if (z) {
                layoutParams.height = this.fyK;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }
}
