package com.baidu.tieba.frs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
/* loaded from: classes6.dex */
public class FrsActivity extends BaseFragmentActivity implements UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.e.b<TbImageView> aGx;
    private FrsTabController dzw;
    private com.baidu.adp.lib.e.b<TbImageView> dzx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dzw = new FrsTabController(this);
        this.dzw.init(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.dzw != null) {
            this.dzw.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dzw != null) {
            this.dzw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.dzw != null) {
            this.dzw.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dzw != null) {
            this.dzw.onDestroy();
        }
        a.ayM().reset();
        if (!com.baidu.tbadk.core.util.ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.dzw != null) {
            this.dzw.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.dzw != null) {
            this.dzw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dzw != null ? this.dzw.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dzw != null) {
            this.dzw.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dzw != null) {
            return this.dzw.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.dzw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dzw.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a gQ(int i) {
        if (this.dzw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.dzw.gQ(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.dzw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.dzw.a(bVar);
        }
    }

    public FrsFragment ayX() {
        if (this.dzw == null) {
            return null;
        }
        return this.dzw.ayX();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayY() {
        if (this.dzx == null) {
            this.dzx = FrsCommonImageLayout.s(getPageContext().getPageActivity(), 12);
        }
        return this.dzx;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View Eg() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (this.aGx == null) {
            this.aGx = UserIconBox.l(getPageContext().getPageActivity(), 8);
        }
        return this.aGx;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        ayX().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void ge(boolean z) {
        if (this.dzw != null) {
            FragmentTabHost aBg = this.dzw.aBg();
            if (aBg != null && aBg.getFragmentTabWidget() != null) {
                if (z) {
                    aBg.cV(2);
                } else {
                    aBg.cV(4);
                }
            }
            this.dzw.gx(z);
        }
    }
}
