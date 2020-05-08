package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dYP;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dXE = false;
        this.dXD = 3;
        this.dWM = new TopicDetaiInputContainer(context);
        this.dYP = ((TopicDetaiInputContainer) this.dWM).getInputView();
        ((TopicDetaiInputContainer) this.dWM).setHint(context.getString(R.string.say_your_point));
        this.dXF = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dYP;
    }
}
