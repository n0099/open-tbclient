package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.lang.ref.WeakReference;
/* loaded from: classes16.dex */
public class HomePageYoungsterTopView extends RelativeLayout {
    private TextView iRe;
    private ImageView iRf;
    private b iRg;
    private a iRh;
    private TbPageContext<?> pageContext;

    /* loaded from: classes16.dex */
    public interface a {
        void cyf();
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
        this.iRe = (TextView) findViewById(R.id.youngster_top_text);
        this.iRf = (ImageView) findViewById(R.id.youngster_top_delete);
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.youngster_open_title) + "，" + getContext().getString(R.string.youngster_homgpage_top_text));
        this.iRg = new b(getContext());
        spannableString.setSpan(this.iRg, 9, 13, 17);
        this.iRe.setText(spannableString);
        this.iRe.setMovementMethod(LinkMovementMethod.getInstance());
        this.iRf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageYoungsterTopView.this.iRh != null) {
                    HomePageYoungsterTopView.this.iRh.cyf();
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnDeleteClick(a aVar) {
        this.iRh = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.iRe, R.color.cp_cont_j);
        ap.setImageResource(this.iRf, R.drawable.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class b extends ClickableSpan {
        WeakReference<Context> iRj;

        public b(Context context) {
            this.iRj = new WeakReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Context context = this.iRj.get();
            if (context != null && com.baidu.tbadk.youngster.b.b.bze()) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(context);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            }
        }
    }
}
