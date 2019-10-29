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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class SecretHintActivity extends BaseActivity<SecretHintActivity> {
    private TextView dem;
    private TextView den;
    private TextView deo;
    private ClickableSpan dep = new ClickableSpan() { // from class: com.baidu.tieba.SecretHintActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.SecretHintActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(SecretHintActivity.this.getResources().getColor(17170445));
            }
            ba.amQ().a(SecretHintActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SecretHintActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    private View.OnClickListener deq = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SecretHintActivity.this.showDialog();
            an anVar = new an("c13295");
            anVar.bS("obj_locate", "2");
            TiebaStatic.log(anVar);
        }
    };
    private View.OnClickListener der = new View.OnClickListener() { // from class: com.baidu.tieba.SecretHintActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_secret_is_show", true);
            if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                SecretHintActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(SecretHintActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
            } else {
                SecretHintActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(SecretHintActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
            }
            SecretHintActivity.this.finish();
            an anVar = new an("c13295");
            anVar.bS("obj_locate", "1");
            TiebaStatic.log(anVar);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.secret_hint_activity);
        initUI();
        initListener();
        setSwipeBackEnabled(false);
        TiebaStatic.log(new an("c13294"));
    }

    private void initUI() {
        this.dem = (TextView) findViewById(R.id.secret_hint_footer);
        this.den = (TextView) findViewById(R.id.unok_text);
        this.deo = (TextView) findViewById(R.id.ok_text);
        SpannableString spannableString = new SpannableString(getString(R.string.secret_hint_footer));
        spannableString.setSpan(this.dep, 39, 45, 33);
        spannableString.setSpan(new ForegroundColorSpan(am.getColor(0, R.color.cp_link_tip_a)), 39, 45, 33);
        this.dem.setText(spannableString);
        this.dem.setMovementMethod(LinkMovementMethod.getInstance());
        onChangeSkinType(0);
    }

    private void initListener() {
        this.den.setOnClickListener(this.deq);
        this.deo.setOnClickListener(this.der);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Activity currentActivity = com.baidu.adp.base.a.em().currentActivity();
        if (currentActivity != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(currentActivity);
            aVar.nn(getString(R.string.secret_hint_dialog_content));
            aVar.nm(getString(R.string.secret_hint_dialog_title));
            aVar.setTitleShowCenter(true);
            aVar.setAutoNight(false);
            aVar.a(getString(R.string.know), new a.b() { // from class: com.baidu.tieba.SecretHintActivity.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(((com.baidu.adp.base.f) currentActivity).getPageContext());
            aVar.akO();
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
