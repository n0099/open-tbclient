package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import d.a.c.e.p.l;
import d.a.n0.v3.c;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextViewNew extends AbsFloorImageTextView {
    public static final int r = l.g(TbadkApplication.getInst(), R.dimen.tbds348);
    public static final int s = l.g(TbadkApplication.getInst(), R.dimen.tbds308);
    public TbRichTextView n;
    public EditorScrollView o;
    public int p;
    public boolean q;

    public FloorImageTextViewNew(Context context) {
        super(context);
        this.q = false;
        h(context);
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        setVisibility(this.q ? 0 : 8);
        if (z) {
            layoutParams.height = this.p;
            setLayoutParams(layoutParams);
            return;
        }
        layoutParams.height = 0;
        setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void e(boolean z) {
        setExpandState(z);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void f(ImageUrlData imageUrlData) {
        this.f12606e = imageUrlData;
        JSONArray jSONArray = null;
        if (imageUrlData != null) {
            try {
                if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                    jSONArray = new JSONArray(imageUrlData.richTextArray);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (imageUrlData != null && jSONArray != null && jSONArray.length() > 0) {
            this.q = true;
            c.a().d(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
            TbRichText S = TbRichTextView.S(getContext(), jSONArray, false);
            g(d(S.toString()));
            this.n.setText(S);
        } else {
            this.q = false;
        }
        setVisibility(this.q ? 0 : 8);
    }

    public final void g(Pair<Integer, Integer> pair) {
        if (pair == null) {
            return;
        }
        if (((Integer) pair.second).intValue() > 2) {
            if (i()) {
                this.p = s + AbsFloorImageTextView.f12604h + AbsFloorImageTextView.f12605i;
            } else {
                this.p = r + AbsFloorImageTextView.f12604h + AbsFloorImageTextView.f12605i;
            }
        } else {
            this.p = -2;
        }
        a(this.p);
    }

    public final void h(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        TbRichTextView tbRichTextView = (TbRichTextView) findViewById(R.id.textview);
        this.n = tbRichTextView;
        tbRichTextView.setVerticalScrollBarEnabled(true);
        this.n.setTextSize(AbsFloorImageTextView.m);
        this.n.setTextColor(SkinManager.getColor(R.color.white_alpha83));
        this.n.S = true;
        EditorScrollView editorScrollView = (EditorScrollView) findViewById(R.id.scrollview);
        this.o = editorScrollView;
        editorScrollView.setPadding(0, l.g(TbadkApplication.getInst(), R.dimen.tbds34), 0, AbsFloorImageTextView.f12605i);
        this.o.setOnTouchListener(this.f12608g);
        ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(TbadkApplication.getInst(), R.dimen.tbds174);
        setVisibility(8);
    }

    public final boolean i() {
        float h2 = l.h(getContext());
        int i2 = l.i(getContext());
        int k = l.k(getContext());
        double d2 = h2;
        int i3 = (d2 > 3.0d ? 1 : (d2 == 3.0d ? 0 : -1));
        if (i3 != 0 || k < 1920 || i2 < 2049) {
            if (i3 != 0 || k < 1080 || i2 < 2280) {
                return d2 == 3.5d && i2 >= 2434;
            }
            return true;
        }
        return true;
    }
}
