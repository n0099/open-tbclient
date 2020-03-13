package com.baidu.tieba.ala.liveroom.s;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import java.lang.reflect.Field;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class c extends Dialog {
    Runnable akS;
    private m ale;
    private TextView dsM;
    private ImageView fkh;
    private RelativeLayout fki;
    private EditText fkj;
    private TextView fkk;
    private Context mContext;
    private TbPageContext mPageContext;
    private String otherParams;

    public c(@NonNull Activity activity, TbPageContext tbPageContext, m mVar, String str) {
        super(activity);
        this.akS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.s.c.6
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.showSoftKeyPad(c.this.mContext, c.this.fkj);
            }
        };
        this.mContext = activity;
        this.mPageContext = tbPageContext;
        this.ale = mVar;
        this.otherParams = str;
        initView();
    }

    private void initView() {
        setContentView(a.h.view_rename_panel);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setSoftInputMode(16);
        getWindow().setGravity(17);
        getWindow().setAttributes(getWindow().getAttributes());
        this.fkk = (TextView) findViewById(a.g.rename_restrict);
        this.fkk.setText(Html.fromHtml(this.mContext.getString(a.i.rename_txt_restrict, 0, 20)));
        this.fkh = (ImageView) findViewById(a.g.close);
        this.fkh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
            }
        });
        this.fki = (RelativeLayout) findViewById(a.g.edit_rename_rl);
        this.fki.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.fkj.requestFocus();
                c.this.fkj.post(c.this.akS);
            }
        });
        this.fkj = (EditText) findViewById(a.g.edit_rename);
        this.fkj.setCursorVisible(true);
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                declaredField.set(this.fkj, Integer.valueOf(a.f.sdk_cursor_hk_bg));
            } else {
                declaredField.set(this.fkj, Integer.valueOf(a.f.sdk_cursor_qm_bg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fkj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.s.c.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                c.this.k(charSequence);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        b(this.fkj);
        this.fkj.setFocusableInTouchMode(true);
        this.fkj.requestFocus();
        this.dsM = (TextView) findViewById(a.g.rename_confirm);
        this.dsM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.s.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.fkj == null || c.this.fkj.getText() == null || TextUtils.isEmpty(c.this.fkj.getText().toString())) {
                    if (c.this.mPageContext != null) {
                        c.this.mPageContext.showToast(c.this.mPageContext.getPageActivity().getResources().getString(a.i.sdk_nickname_empty));
                        return;
                    }
                    return;
                }
                c.this.zt("nickname=" + c.this.fkj.getText().toString());
            }
        });
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_POP_SHOW);
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    public void b(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.baidu.tieba.ala.liveroom.s.c.5
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                int zs = c.zs(charSequence.toString());
                int zs2 = c.zs(spanned.toString());
                if (!c.isAccount(charSequence.toString()) || zs + zs2 > 20) {
                    return "";
                }
                return null;
            }
        }});
    }

    public static int zs(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        return str.length();
    }

    public static boolean isAccount(String str) {
        return Pattern.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D\\w]+$").matcher(str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StringFormatMatches"})
    public void k(CharSequence charSequence) {
        this.fkk.setText(Html.fromHtml(this.mContext.getString(a.i.rename_txt_restrict, Integer.valueOf(charSequence.length()), 20)));
    }

    public void onSuccess() {
        dismiss();
    }

    public void onFail() {
        if (this.dsM != null) {
            this.dsM.setClickable(true);
            this.dsM.setBackgroundResource(a.f.ala_live_follow_btn_radius_20_selector_qm);
        }
    }

    public void zt(String str) {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.REMANE_POP_CLICK);
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (com.baidu.live.r.a.zh().zi() != null) {
            this.dsM.setClickable(false);
            this.dsM.setBackgroundResource(a.f.sdk_round_btn_qm_bg_radius_12_s);
            com.baidu.live.r.a.zh().zi().dX(str);
        }
    }
}
