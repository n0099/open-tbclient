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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SecretHintActivity extends BaseActivity<SecretHintActivity> {
    private TextView cKf;
    private TextView cKg;
    private TextView cKh;
    private ClickableSpan cKi = new ClickableSpan() { // from class: com.baidu.tieba.SecretHintActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.SecretHintActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(SecretHintActivity.this.getResources().getColor(17170445));
            }
            ba.adD().a(SecretHintActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SecretHintActivity.this.getResources().getColor(d.C0277d.cp_link_tip_c));
        }
    };
    private View.OnClickListener cKj = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SecretHintActivity.this.showDialog();
            am amVar = new am("c13295");
            amVar.bJ("obj_locate", "2");
            TiebaStatic.log(amVar);
        }
    };
    private View.OnClickListener cKk = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_secret_is_show", true);
            if (MessageManager.getInstance().findTask(2015001) != null) {
                SecretHintActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(SecretHintActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
            } else {
                SecretHintActivity.this.sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(SecretHintActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            SecretHintActivity.this.finish();
            am amVar = new am("c13295");
            amVar.bJ("obj_locate", "1");
            TiebaStatic.log(amVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.secret_hint_activity);
        initUI();
        initListener();
        setSwipeBackEnabled(false);
        TiebaStatic.log(new am("c13294"));
    }

    private void initUI() {
        this.cKf = (TextView) findViewById(d.g.secret_hint_footer);
        this.cKg = (TextView) findViewById(d.g.unok_text);
        this.cKh = (TextView) findViewById(d.g.ok_text);
        SpannableString spannableString = new SpannableString(getString(d.j.secret_hint_footer));
        spannableString.setSpan(this.cKi, 39, 45, 33);
        spannableString.setSpan(new ForegroundColorSpan(al.getColor(0, d.C0277d.cp_link_tip_a)), 39, 45, 33);
        this.cKf.setText(spannableString);
        this.cKf.setMovementMethod(LinkMovementMethod.getInstance());
        onChangeSkinType(0);
    }

    private void initListener() {
        this.cKg.setOnClickListener(this.cKj);
        this.cKh.setOnClickListener(this.cKk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Activity fU = com.baidu.adp.base.a.fT().fU();
        if (fU != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fU);
            aVar.ly(getString(d.j.secret_hint_dialog_content));
            aVar.lx(getString(d.j.secret_hint_dialog_title));
            aVar.dx(true);
            aVar.setAutoNight(false);
            aVar.a(getString(d.j.know), new a.b() { // from class: com.baidu.tieba.SecretHintActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(((com.baidu.adp.base.f) fU).getPageContext());
            aVar.aaZ();
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
