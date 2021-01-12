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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tieba.R;
import com.baidu.tieba.write.j;
/* loaded from: classes2.dex */
public class b {
    private View jqV;
    private View jqW;
    private TextView jqX;
    private TextView jqY;
    private TextView jqZ;
    private ImageView jra;
    private EditText jrb;
    private SpanGroupEditText jrc;
    private a jrd;
    private boolean jre;
    private Context mContext;
    private View.OnClickListener onClickListener;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void cGo();
    }

    public b(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        this.rootView = LayoutInflater.from(this.mContext).inflate(R.layout.forum_rule_edit_item, (ViewGroup) null);
        this.jqV = this.rootView.findViewById(R.id.item_divider);
        this.jqY = (TextView) this.rootView.findViewById(R.id.item_title_index);
        this.jra = (ImageView) this.rootView.findViewById(R.id.item_del);
        this.jrb = (EditText) this.rootView.findViewById(R.id.item_title);
        this.jqX = (TextView) this.rootView.findViewById(R.id.item_title_number);
        this.jqW = this.rootView.findViewById(R.id.titile_divider);
        this.jrc = (SpanGroupEditText) this.rootView.findViewById(R.id.item_content);
        this.jqZ = (TextView) this.rootView.findViewById(R.id.item_content_number);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jqX, 0, 30);
        com.baidu.tieba.frs.forumRule.view.a.b(this.jqZ, 0, 300);
        this.jrb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jqX, editable.toString().length(), 30);
                if (b.this.jrd != null) {
                    b.this.jrd.cGo();
                }
                if (b.this.jre) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jrb).nV(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jrc).nV(R.color.CAM_X0105);
                    b.this.jre = false;
                }
            }
        });
        this.jrc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                com.baidu.tieba.frs.forumRule.view.a.b(b.this.jqZ, editable.toString().length(), 300);
                if (b.this.jrd != null) {
                    b.this.jrd.cGo();
                }
                if (b.this.jre) {
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jrb).nV(R.color.CAM_X0105);
                    com.baidu.tbadk.core.elementsMaven.c.bv(b.this.jrc).nV(R.color.CAM_X0105);
                    b.this.jre = false;
                }
                if (b.this.jrc.getLineCount() > 6) {
                    b.this.jrc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.2.1
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
                    b.this.jrc.setOnTouchListener(null);
                }
            }
        });
        this.jrb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jrb);
            }
        });
        this.jrc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l.showSoftKeyPad(b.this.mContext, b.this.jrc);
            }
        });
        btV();
        this.jrc.buH();
    }

    private void btV() {
        if (this.rootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqV).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqW).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqY).nV(R.color.CAM_X0107).nX(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqX).nV(R.color.CAM_X0111);
            this.jra.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jrc.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jrc.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jrb.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jrb.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                j.h(this.jrb, R.drawable.edittext_cursor);
                j.h(this.jrc, R.drawable.edittext_cursor);
                return;
            }
            j.h(this.jrb, R.drawable.edittext_cursor_1);
            j.h(this.jrc, R.drawable.edittext_cursor_1);
        }
    }

    public View getRootView() {
        return this.rootView;
    }

    public SpanGroupEditText cGp() {
        return this.jrc;
    }

    public EditText cGq() {
        return this.jrb;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.jra.setOnClickListener(this.onClickListener);
    }

    public void a(a aVar) {
        this.jrd = aVar;
    }

    public void zr(int i) {
        if (this.jqY != null) {
            this.jqY.setText(String.format(this.mContext.getString(R.string.forum_rule_title_index), zs(i)));
        }
    }

    public void qZ(boolean z) {
        this.jre = z;
    }

    private String zs(int i) {
        return com.baidu.tieba.frs.forumRule.d.a.zo(i + 5);
    }
}
