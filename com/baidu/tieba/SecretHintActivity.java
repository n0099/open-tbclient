package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SecretHintActivity extends BaseActivity<SecretHintActivity> {
    private TextView buN;
    private TextView buO;
    private TextView buP;
    private ClickableSpan buQ = new ClickableSpan() { // from class: com.baidu.tieba.SecretHintActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.SecretHintActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(SecretHintActivity.this.getResources().getColor(17170445));
            }
            ay.Db().a(SecretHintActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SecretHintActivity.this.getResources().getColor(e.d.cp_link_tip_c));
        }
    };
    private View.OnClickListener buR = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SecretHintActivity.this.showDialog();
            am amVar = new am("c13295");
            amVar.ax("obj_locate", "2");
            TiebaStatic.log(amVar);
        }
    };
    private View.OnClickListener buS = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_secret_is_show", true);
            SecretHintActivity.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(SecretHintActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
            SecretHintActivity.this.finish();
            am amVar = new am("c13295");
            amVar.ax("obj_locate", "1");
            TiebaStatic.log(amVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.secret_hint_activity);
        initUI();
        initListener();
        setSwipeBackEnabled(false);
        TiebaStatic.log(new am("c13294"));
    }

    private void initUI() {
        this.buN = (TextView) findViewById(e.g.secret_hint_footer);
        this.buO = (TextView) findViewById(e.g.unok_text);
        this.buP = (TextView) findViewById(e.g.ok_text);
        SpannableString spannableString = new SpannableString(getString(e.j.secret_hint_footer));
        spannableString.setSpan(this.buQ, 39, 45, 33);
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(0, e.d.cp_link_tip_a)), 39, 45, 33);
        this.buN.setText(spannableString);
        this.buN.setMovementMethod(LinkMovementMethod.getInstance());
        onChangeSkinType(0);
    }

    private void initListener() {
        this.buO.setOnClickListener(this.buR);
        this.buP.setOnClickListener(this.buS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Activity fX = com.baidu.adp.base.a.fW().fX();
        if (fX != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fX);
            aVar.ej(getString(e.j.secret_hint_dialog_content));
            aVar.ei(getString(e.j.secret_hint_dialog_title));
            aVar.bl(true);
            aVar.setAutoNight(false);
            aVar.a(getString(e.j.know), new a.b() { // from class: com.baidu.tieba.SecretHintActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(((com.baidu.adp.base.f) fX).getPageContext());
            aVar.AB();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(0);
    }
}
