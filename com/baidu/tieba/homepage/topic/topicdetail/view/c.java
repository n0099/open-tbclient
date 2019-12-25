package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class c extends l {
    private EditText dul;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dta = false;
        this.dsZ = 3;
        this.dsh = new TopicDetaiInputContainer(context);
        this.dul = ((TopicDetaiInputContainer) this.dsh).getInputView();
        ((TopicDetaiInputContainer) this.dsh).setHint(context.getString(R.string.say_your_point));
        this.dtb = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dul;
    }
}
