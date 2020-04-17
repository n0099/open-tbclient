package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dYK;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dXz = false;
        this.dXy = 3;
        this.dWH = new TopicDetaiInputContainer(context);
        this.dYK = ((TopicDetaiInputContainer) this.dWH).getInputView();
        ((TopicDetaiInputContainer) this.dWH).setHint(context.getString(R.string.say_your_point));
        this.dXA = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dYK;
    }
}
