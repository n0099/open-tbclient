package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    private static final int clf = l.g(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int clg = l.g(TbadkApplication.getInst(), R.dimen.tbds308);
    private TbRichTextView ckY;
    private EditorScrollView ckZ;
    private int cla;

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        al.l(this, R.color.black_alpha50);
        this.ckY = (TbRichTextView) findViewById(R.id.textview);
        this.ckY.setVerticalScrollBarEnabled(true);
        this.ckY.setTextSize(cke);
        this.ckY.setTextColor(al.getColor(R.color.white_alpha83));
        this.ckZ = (EditorScrollView) findViewById(R.id.scrollview);
        this.ckZ.setPadding(0, TOP, 0, BOTTOM);
        this.ckZ.setOnTouchListener(this.ckh);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (apd()) {
                    this.cla = clg + TOP + BOTTOM;
                } else {
                    this.cla = clf + TOP + BOTTOM;
                }
            } else {
                this.cla = -2;
            }
            jJ(this.cla);
        }
    }

    private boolean apd() {
        float ai = l.ai(getContext());
        int ah = l.ah(getContext());
        int af = l.af(getContext());
        if (ai != 3.0d || af < 1920 || ah < 2049) {
            if (ai != 3.0d || af < 1080 || ah < 2280) {
                return ((double) ai) == 3.5d && ah >= 2434;
            }
            return true;
        }
        return true;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.ckf = imageUrlData;
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
                    com.baidu.tieba.view.c.cvc().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(po(a.toString()));
                    this.ckY.setText(a);
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
    public void o(boolean z, boolean z2) {
    }
}
