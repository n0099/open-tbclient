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
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int ccX = l.h(TbadkApplication.getInst(), d.e.tbds348);
    private static final int ccY = l.h(TbadkApplication.getInst(), d.e.tbds308);
    private TbRichTextView ccQ;
    private EditorScrollView ccR;
    private int ccS;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.floorimage_textview_layout_new, (ViewGroup) this, true);
        al.l(this, d.C0236d.black_alpha50);
        this.ccQ = (TbRichTextView) findViewById(d.g.textview);
        this.ccQ.setVerticalScrollBarEnabled(true);
        this.ccQ.setTextSize(cbV);
        this.ccQ.setTextColor(al.getColor(d.C0236d.white_alpha83));
        this.ccR = (EditorScrollView) findViewById(d.g.scrollview);
        this.ccR.setPadding(0, TOP, 0, BOTTOM);
        this.ccR.setOnTouchListener(this.cbY);
        setVisibility(8);
    }

    private void d(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (akg()) {
                    this.ccS = ccY + TOP + BOTTOM;
                } else {
                    this.ccS = ccX + TOP + BOTTOM;
                }
            } else {
                this.ccS = -2;
            }
            iW(this.ccS);
        }
    }

    private boolean akg() {
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
        this.cbW = imageUrlData;
        if (imageUrlData != null && imageUrlData.richTextArray != null && imageUrlData.richTextArray.length() > 0) {
            setVisibility(0);
            com.baidu.tieba.view.c.cmN().setColor(TbadkCoreApplication.getInst().getResources().getColor(d.C0236d.transparent));
            TbRichText a = TbRichTextView.a(getContext(), imageUrlData.richTextArray, false);
            d(oe(a.toString()));
            this.ccQ.setText(a);
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void ep(boolean z) {
    }
}
