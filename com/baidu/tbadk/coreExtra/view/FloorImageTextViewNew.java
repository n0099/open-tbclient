package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int cda = l.h(TbadkApplication.getInst(), d.e.tbds348);
    private static final int cdb = l.h(TbadkApplication.getInst(), d.e.tbds308);
    private TbRichTextView ccT;
    private EditorScrollView ccU;
    private int ccV;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.floorimage_textview_layout_new, (ViewGroup) this, true);
        al.l(this, d.C0277d.black_alpha50);
        this.ccT = (TbRichTextView) findViewById(d.g.textview);
        this.ccT.setVerticalScrollBarEnabled(true);
        this.ccT.setTextSize(cbY);
        this.ccT.setTextColor(al.getColor(d.C0277d.white_alpha83));
        this.ccU = (EditorScrollView) findViewById(d.g.scrollview);
        this.ccU.setPadding(0, TOP, 0, BOTTOM);
        this.ccU.setOnTouchListener(this.ccb);
        setVisibility(8);
    }

    private void d(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (akc()) {
                    this.ccV = cdb + TOP + BOTTOM;
                } else {
                    this.ccV = cda + TOP + BOTTOM;
                }
            } else {
                this.ccV = -2;
            }
            iV(this.ccV);
        }
    }

    private boolean akc() {
        float aR = l.aR(getContext());
        int aQ = l.aQ(getContext());
        int aO = l.aO(getContext());
        if (aR != 3.0d || aO < 1920 || aQ < 2049) {
            if (aR != 3.0d || aO < 1080 || aQ < 2280) {
                return ((double) aR) == 3.5d && aQ >= 2434;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.cbZ = imageUrlData;
        JSONArray jSONArray2 = null;
        if (imageUrlData == null) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(imageUrlData.richTextArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONArray2 = jSONArray;
        if (imageUrlData != null && jSONArray2 != null && jSONArray2.length() > 0) {
            setVisibility(0);
            com.baidu.tieba.view.c.cmY().setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0277d.transparent));
            TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
            d(og(a.toString()));
            this.ccT.setText(a);
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void ep(boolean z) {
    }
}
