package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int cAs = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int cAt = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView cAl;
    private EditorScrollView cAm;
    private int cAn;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        am.setBackgroundColor(this, R.color.black_alpha50);
        this.cAl = (TbRichTextView) findViewById(R.id.textview);
        this.cAl.setVerticalScrollBarEnabled(true);
        this.cAl.setTextSize(czs);
        this.cAl.setTextColor(am.getColor(R.color.white_alpha83));
        this.cAm = (EditorScrollView) findViewById(R.id.scrollview);
        this.cAm.setPadding(0, czp, 0, czq);
        this.cAm.setOnTouchListener(this.czv);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (asr()) {
                    this.cAn = cAt + czp + czq;
                } else {
                    this.cAn = cAs + czp + czq;
                }
            } else {
                this.cAn = -2;
            }
            jq(this.cAn);
        }
    }

    private boolean asr() {
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
        this.czt = imageUrlData;
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
                    com.baidu.tieba.view.c.cwP().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(pa(a.toString()));
                    this.cAl.setText(a);
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
    }
}
