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
    private TbRichTextView cms;
    private EditorScrollView cmt;
    private int cmu;
    private static final int cmz = l.g(TbadkApplication.getInst(), R.dimen.tbds348);
    private static final int cmA = l.g(TbadkApplication.getInst(), R.dimen.tbds308);

    public FloorImageTextViewNew(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout_new, (ViewGroup) this, true);
        am.l(this, R.color.black_alpha50);
        this.cms = (TbRichTextView) findViewById(R.id.textview);
        this.cms.setVerticalScrollBarEnabled(true);
        this.cms.setTextSize(clx);
        this.cms.setTextColor(am.getColor(R.color.white_alpha83));
        this.cmt = (EditorScrollView) findViewById(R.id.scrollview);
        this.cmt.setPadding(0, clu, 0, clv);
        this.cmt.setOnTouchListener(this.clA);
        setVisibility(8);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            if (((Integer) pair.second).intValue() > 5) {
                if (aql()) {
                    this.cmu = cmA + clu + clv;
                } else {
                    this.cmu = cmz + clu + clv;
                }
            } else {
                this.cmu = -2;
            }
            jQ(this.cmu);
        }
    }

    private boolean aql() {
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
        this.cly = imageUrlData;
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
                    com.baidu.tieba.view.c.cyn().setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(pF(a.toString()));
                    this.cms.setText(a);
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
    public void q(boolean z, boolean z2) {
    }
}
