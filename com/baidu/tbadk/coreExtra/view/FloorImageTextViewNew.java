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
/* loaded from: classes15.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int evo = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int evp = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView dKu;
    private EditorScrollView evq;
    private int evr;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        this.dKu = (TbRichTextView) findViewById(R.id.textview);
        this.dKu.setVerticalScrollBarEnabled(true);
        this.dKu.setTextSize(euD);
        this.dKu.setTextColor(ao.getColor(R.color.white_alpha83));
        this.evq = (EditorScrollView) findViewById(R.id.scrollview);
        this.evq.setPadding(0, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34), 0, BOTTOM);
        this.evq.setOnTouchListener(this.euG);
        ((ViewGroup.MarginLayoutParams) this.evq.getLayoutParams()).topMargin = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds174);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (bgY()) {
                    this.evr = evp + TOP + BOTTOM;
                } else {
                    this.evr = evo + TOP + BOTTOM;
                }
            } else {
                this.evr = -2;
            }
            nz(this.evr);
        }
    }

    private boolean bgY() {
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
        this.euE = imageUrlData;
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
                    com.baidu.tieba.view.c.dtD().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(yX(a.toString()));
                    this.dKu.setText(a);
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
    public void iw(boolean z) {
        setExpandState(z);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(0);
            if (z) {
                layoutParams.height = this.evr;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }
}
