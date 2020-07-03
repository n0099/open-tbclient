package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText evO;

    public c(Context context) {
        super(context, (String) null, 29);
        this.euA = false;
        this.euz = 3;
        this.etH = new TopicDetaiInputContainer(context);
        this.evO = ((TopicDetaiInputContainer) this.etH).getInputView();
        ((TopicDetaiInputContainer) this.etH).setHint(context.getString(R.string.say_your_point));
        this.euB = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.evO;
    }
}
