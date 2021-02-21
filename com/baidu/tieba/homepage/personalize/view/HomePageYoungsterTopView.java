package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class HomePageYoungsterTopView extends RelativeLayout {
    private TextView kmF;
    private ImageView kmG;
    private b kmH;
    private a kmI;
    private TbPageContext<?> pageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void cRw();
    }

    public HomePageYoungsterTopView(TbPageContext<?> tbPageContext) {
        this(tbPageContext.getPageActivity());
        this.pageContext = tbPageContext;
    }

    public HomePageYoungsterTopView(Context context) {
        this(context, null);
    }

    public HomePageYoungsterTopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HomePageYoungsterTopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_homepage_youngster_top, this);
        this.kmF = (TextView) findViewById(R.id.youngster_top_text);
        this.kmG = (ImageView) findViewById(R.id.youngster_top_delete);
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.youngster_open_title) + "，" + getContext().getString(R.string.youngster_homgpage_top_text));
        this.kmH = new b(getContext());
        spannableString.setSpan(this.kmH, 9, 13, 33);
        this.kmF.setText(spannableString);
        this.kmF.setMovementMethod(LinkMovementMethod.getInstance());
        this.kmG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageYoungsterTopView.this.kmI != null) {
                    HomePageYoungsterTopView.this.kmI.cRw();
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnDeleteClick(a aVar) {
        this.kmI = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.CAM_X0206);
        ap.setViewTextColor(this.kmF, R.color.CAM_X0107);
        ap.setImageResource(this.kmG, R.drawable.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends ClickableSpan {
        WeakReference<Context> kmK;

        public b(Context context) {
            this.kmK = new WeakReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Context context = this.kmK.get();
            if (context != null && com.baidu.tbadk.youngster.b.c.bJf()) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(context);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            }
        }
    }
}
