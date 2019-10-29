package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText cHi;

    public c(Context context) {
        super(context, (String) null, 29);
        this.cFX = false;
        this.cFW = 3;
        this.cFe = new TopicDetaiInputContainer(context);
        this.cHi = ((TopicDetaiInputContainer) this.cFe).getInputView();
        ((TopicDetaiInputContainer) this.cFe).setHint(context.getString(R.string.say_your_point));
        this.cFY = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.cHi;
    }
}
