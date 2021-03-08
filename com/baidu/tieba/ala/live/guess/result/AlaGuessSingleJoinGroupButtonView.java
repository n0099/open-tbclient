package com.baidu.tieba.ala.live.guess.result;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
/* loaded from: classes10.dex */
public class AlaGuessSingleJoinGroupButtonView extends FrameLayout {
    private Button hjg;
    private a hjh;

    /* loaded from: classes10.dex */
    public interface a {
        void abx();
    }

    public AlaGuessSingleJoinGroupButtonView(Context context) {
        super(context);
        init(context);
    }

    public AlaGuessSingleJoinGroupButtonView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaGuessSingleJoinGroupButtonView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_guess_single_bottom_join_group_view, this);
        this.hjg = (Button) findViewById(a.f.btn_guess_single_join_groups);
    }

    public void setData(final boolean z, final String str) {
        this.hjg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.guess.result.AlaGuessSingleJoinGroupButtonView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaGuessSingleJoinGroupButtonView.this.hjh != null) {
                    AlaGuessSingleJoinGroupButtonView.this.hjh.abx();
                }
                AlaGuessSingleJoinGroupButtonView.this.t(z, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(boolean z, String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
            return;
        }
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.isFullScreen = z;
        cVar.url = str;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    public void setOnClickJoinButtonListener(a aVar) {
        this.hjh = aVar;
    }
}
