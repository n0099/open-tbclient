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
/* loaded from: classes22.dex */
public class HomePageYoungsterTopView extends RelativeLayout {
    private TextView jHn;
    private ImageView jHo;
    private b jHp;
    private a jHq;
    private TbPageContext<?> pageContext;

    /* loaded from: classes22.dex */
    public interface a {
        void cLf();
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
        this.jHn = (TextView) findViewById(R.id.youngster_top_text);
        this.jHo = (ImageView) findViewById(R.id.youngster_top_delete);
        SpannableString spannableString = new SpannableString(getContext().getString(R.string.youngster_open_title) + "，" + getContext().getString(R.string.youngster_homgpage_top_text));
        this.jHp = new b(getContext());
        spannableString.setSpan(this.jHp, 9, 13, 17);
        this.jHn.setText(spannableString);
        this.jHn.setMovementMethod(LinkMovementMethod.getInstance());
        this.jHo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HomePageYoungsterTopView.this.jHq != null) {
                    HomePageYoungsterTopView.this.jHq.cLf();
                }
            }
        });
        onChangeSkinType();
    }

    public void setOnDeleteClick(a aVar) {
        this.jHq = aVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.jHn, R.color.cp_cont_j);
        ap.setImageResource(this.jHo, R.drawable.icon_home_card_delete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class b extends ClickableSpan {
        WeakReference<Context> jHs;

        public b(Context context) {
            this.jHs = new WeakReference<>(context);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ap.getColor(R.color.cp_link_tip_a));
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Context context = this.jHs.get();
            if (context != null && com.baidu.tbadk.youngster.b.c.bHs()) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(context);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(3);
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            }
        }
    }
}
