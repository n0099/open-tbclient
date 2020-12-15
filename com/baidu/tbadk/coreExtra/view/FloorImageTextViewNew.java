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
/* loaded from: classes21.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int foZ = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int fpa = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView eBC;
    private EditorScrollView fpb;
    private int fpc;
    private boolean fpd;

    public FloorImageTextViewNew(Context context) {
        super(context);
        this.fpd = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        this.eBC = (TbRichTextView) findViewById(R.id.textview);
        this.eBC.setVerticalScrollBarEnabled(true);
        this.eBC.setTextSize(fop);
        this.eBC.setTextColor(ap.getColor(R.color.white_alpha83));
        this.fpb = (EditorScrollView) findViewById(R.id.scrollview);
        this.fpb.setPadding(0, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34), 0, BOTTOM);
        this.fpb.setOnTouchListener(this.fos);
        ((ViewGroup.MarginLayoutParams) this.fpb.getLayoutParams()).topMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds174);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 2) {
                if (bAx()) {
                    this.fpc = fpa + TOP + BOTTOM;
                } else {
                    this.fpc = foZ + TOP + BOTTOM;
                }
            } else {
                this.fpc = -2;
            }
            rP(this.fpc);
        }
    }

    private boolean bAx() {
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
        this.foq = imageUrlData;
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
                    this.fpd = true;
                    com.baidu.tieba.view.c.dXS().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a2 = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(Dk(a2.toString()));
                    this.eBC.setText(a2);
                } else {
                    this.fpd = false;
                }
                setVisibility(!this.fpd ? 0 : 8);
            }
        }
        jSONArray = null;
        jSONArray2 = jSONArray;
        if (imageUrlData == null) {
        }
        this.fpd = false;
        setVisibility(!this.fpd ? 0 : 8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void ke(boolean z) {
        setExpandState(z);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(this.fpd ? 0 : 8);
            if (z) {
                layoutParams.height = this.fpc;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }
}
