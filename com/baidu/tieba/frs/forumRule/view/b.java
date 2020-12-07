package com.baidu.tieba.frs.forumRule.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.write.j;
/* loaded from: classes22.dex */
public class b {
    private View.OnClickListener foP;
    private View jja;
    private View jjb;
    private TextView jjc;
    private TextView jjd;
    private TextView jje;
    private ImageView jjf;
    private EditText jjg;
    private SpanGroupEditText jjh;
    private a jji;
    private boolean jjj;
    private Context mContext;
    private View rootView;

    /* loaded from: classes22.dex */
    public interface a {
        void cHf();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jja = this.rootView.findViewById(R.id.item_divider);
        this.jjd = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jjf = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jjg = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jjc = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jjb = this.rootView.findViewById(R.id.titile_divider);
        this.jjh = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jje = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jjc, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jje, 0, 300);
        this.jjg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jjc, editable.toString().length(), 30);
                if (b.this.jji != null) {
                    b.this.jji.cHf();
                }
                if (b.this.jjj) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(b.this.jjg).ps(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bm(b.this.jjh).ps(R.color.CAM_X0105);
                    b.this.jjj = false;
                }
            }
        });
        this.jjh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jje, editable.toString().length(), 300);
                if (b.this.jji != null) {
                    b.this.jji.cHf();
                }
                if (b.this.jjj) {
                    com.baidu.tbadk.core.elementsMaven.c.bm(b.this.jjg).ps(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bm(b.this.jjh).ps(R.color.CAM_X0105);
                    b.this.jjj = false;
                }
                if (b.this.jjh.getLineCount() > 6) {
                    b.this.jjh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                            } else if (motionEvent.getAction() == 1) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else if (motionEvent.getAction() == 3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                            return false;
                        }
                    });
                } else {
                    b.this.jjh.setOnTouchListener(null);
                }
            }
        });
        this.jjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jjg);
            }
        });
        this.jjh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jjh);
            }
        });
        bvt();
        this.jjh.bwh();
    }

    private void bvt() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jja).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jjb).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jjd).ps(R.color.CAM_X0107).pu(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jjc).ps(R.color.CAM_X0111);
            this.jjf.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jjh.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jjh.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jjg.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jjg.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jjg, R.drawable.edittext_cursor);
                j.h(this.jjh, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jjg, R.drawable.edittext_cursor_1);
            j.h(this.jjh, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cHg() {
        return this.jjh;
    }

    public EditText cHh() {
        return this.jjg;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.foP = onClickListener;
        this.jjf.setOnClickListener(this.foP);
    }

    public void a(a aVar) {
        this.jji = aVar;
    }

    public void AK(int i) {
        if (this.jjd != null) {
            this.jjd.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), AL(i)));
        }
    }

    public void qF(boolean z) {
        this.jjj = z;
    }

    private String AL(int i) {
        return AM(i + 5);
    }

    public String AM(int i) {
        switch (i) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
            case 11:
                return "十一";
            case 12:
                return "十二";
            case 13:
                return "十三";
            case 14:
                return "十四";
            case 15:
                return "十五";
            case 16:
                return "十六";
            case 17:
                return "十七";
            case 18:
                return "十八";
            case 19:
                return "十九";
            case 20:
                return "二十";
            default:
                return "";
        }
    }
}
