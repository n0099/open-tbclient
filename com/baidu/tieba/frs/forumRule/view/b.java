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
/* loaded from: classes2.dex */
public class b {
    private View jwP;
    private View jwQ;
    private TextView jwR;
    private TextView jwS;
    private TextView jwT;
    private ImageView jwU;
    private EditText jwV;
    private SpanGroupEditText jwW;
    private a jwX;
    private boolean jwY;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void cHI();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jwP = this.rootView.findViewById(R.id.item_divider);
        this.jwS = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jwU = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jwV = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jwR = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jwQ = this.rootView.findViewById(R.id.titile_divider);
        this.jwW = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jwT = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jwR, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jwT, 0, 300);
        this.jwV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jwR, editable.toString().length(), 30);
                if (b.this.jwX != null) {
                    b.this.jwX.cHI();
                }
                if (b.this.jwY) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwV).nY(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwW).nY(R.color.CAM_X0105);
                    b.this.jwY = false;
                }
            }
        });
        this.jwW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jwT, editable.toString().length(), 300);
                if (b.this.jwX != null) {
                    b.this.jwX.cHI();
                }
                if (b.this.jwY) {
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwV).nY(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.br(b.this.jwW).nY(R.color.CAM_X0105);
                    b.this.jwY = false;
                }
                if (b.this.jwW.getLineCount() > 6) {
                    b.this.jwW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
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
                    b.this.jwW.setOnTouchListener(null);
                }
            }
        });
        this.jwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jwV);
            }
        });
        this.jwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jwW);
            }
        });
        bup();
        this.jwW.bvb();
    }

    private void bup() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwP).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwQ).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwS).nY(R.color.CAM_X0107).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwR).nY(R.color.CAM_X0111);
            this.jwU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jwW.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jwW.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwV.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwV.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jwV, R.drawable.edittext_cursor);
                j.h(this.jwW, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jwV, R.drawable.edittext_cursor_1);
            j.h(this.jwW, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cHJ() {
        return this.jwW;
    }

    public EditText cHK() {
        return this.jwV;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.jwU.setOnClickListener(this.onClickListener);
    }

    public void a(a aVar) {
        this.jwX = aVar;
    }

    public void zB(int i) {
        if (this.jwS != null) {
            this.jwS.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), zC(i)));
        }
    }

    public void rj(boolean z) {
        this.jwY = z;
    }

    private String zC(int i) {
        return com.baidu.tieba.frs.forumRule.d.a.zy(i + 5);
    }
}
