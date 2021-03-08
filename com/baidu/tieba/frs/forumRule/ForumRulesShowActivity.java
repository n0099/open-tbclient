package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.frs.forumRule.a.a;
import com.baidu.tieba.frs.forumRule.b.b;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.frs.forumRule.view.c;
import com.baidu.tieba.view.BdTopToast;
import java.util.List;
/* loaded from: classes2.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements h {
    private ForumRulesShowModel jwx;
    private c jwy;
    private String mFrom;
    a.InterfaceC0732a jwz = new a.InterfaceC0732a() { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.1
        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void A(boolean z, String str) {
            if (ForumRulesShowActivity.this.jwy != null) {
                if (z) {
                    ForumRulesShowActivity.this.jwy.KQ(str);
                } else {
                    ForumRulesShowActivity.this.jwy.cHY();
                }
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void KD(String str) {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.jwy.addTitle(str);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void a(b bVar) {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.jwy.c(bVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void dp(List<com.baidu.tieba.frs.forumRule.b.c> list) {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.jwy.dt(list);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void a(com.baidu.tieba.frs.forumRule.b.a aVar) {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.jwy.b(aVar);
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void bCk() {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.jwy.cHW();
                ForumRulesShowActivity.this.jwy.cHS();
                ForumRulesShowActivity.this.showNetRefreshView(ForumRulesShowActivity.this.jwy.cHR(), "");
            }
        }

        @Override // com.baidu.tieba.frs.forumRule.a.a.InterfaceC0732a
        public void finish() {
            if (ForumRulesShowActivity.this.jwy != null) {
                ForumRulesShowActivity.this.hideNetRefreshView(ForumRulesShowActivity.this.jwy.cHR());
                ForumRulesShowActivity.this.jwy.cHT();
                ForumRulesShowActivity.this.jwy.cHV();
                ForumRulesShowActivity.this.jwy.cHU();
            }
        }
    };
    private CustomMessageListener jwA = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.frs.forumRule.ForumRulesShowActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(ForumRulesShowActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initView();
        this.jwx.ao(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jwy != null) {
            this.jwy.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        registerListener(this.jwA);
    }

    private void initData(Bundle bundle) {
        this.jwx = new ForumRulesShowModel(this);
        cHg();
    }

    private void initView() {
        if (getIntent() != null) {
            this.mFrom = getIntent().getStringExtra("from");
        }
        this.jwy = new c(this, this.mFrom);
        this.jwy.a(getRefreshView());
    }

    private void cHg() {
        this.jwx.a(this.jwz);
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jwy != null) {
            this.jwy.setFrom(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jwA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jwx != null) {
            this.jwx.destory();
        }
        if (this.jwy != null) {
            this.jwy.destory();
        }
    }

    public void cHh() {
        if (this.jwx != null) {
            this.jwx.cHy();
        }
    }

    public c cHi() {
        return this.jwy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25053) {
            String stringExtra = intent.getStringExtra("group_name");
            if (!intent.getBooleanExtra("from", true)) {
                this.jwy.remove();
                this.jwy.mData.clear();
                this.jwx.cHy();
            }
            new BdTopToast(this, 3000).zm(true).Vg(stringExtra).aR(this.jwy.getRootView());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIk() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIl() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIm() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIn() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIo() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIp() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIq() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        bf.bsY().b(getPageContext(), new String[]{str});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }
}
